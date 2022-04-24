/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.security.jwt;

/**
 *
 * @author ACER
 */
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;
import com.BTL.BTL_BE.service.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;
    @Value("${bezkoder.app.jwtExpirationMs}")
    private int jwtExpirationMs;
    @Value("${bezkoder.app.jwtCookieName}")
    private String jwtCookie;
    public String getJwtFromCookies(HttpServletRequest request) {
      Cookie cookie = WebUtils.getCookie(request, jwtCookie);
      if (cookie != null) {
        return cookie.getValue();
      } else {
        return null;
      }
    }
    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
      String jwt = generateTokenFromUsername(userPrincipal.getUsername(), userPrincipal.getId());
      ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
      return cookie;
    }
    public ResponseCookie getCleanJwtCookie() {
      ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
      return cookie;
    }
    public String getUserNameFromJwtToken(String token) {
      return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public String getIdFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getId();
    }
    public boolean validateJwtToken(String authToken) {
      try {
        Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
        return true;
      } catch (SignatureException e) {
        logger.error("Invalid JWT signature: {}", e.getMessage());
      } catch (MalformedJwtException e) {
        logger.error("Invalid JWT token: {}", e.getMessage());
      } catch (ExpiredJwtException e) {
        logger.error("JWT token is expired: {}", e.getMessage());
      } catch (UnsupportedJwtException e) {
        logger.error("JWT token is unsupported: {}", e.getMessage());
      } catch (IllegalArgumentException e) {
        logger.error("JWT claims string is empty: {}", e.getMessage());
      }
      return false;
    }

    public String generateTokenFromUsername(String username, String UserId) {
      return Jwts.builder()
          .setSubject(username)
          .setId(UserId)
          .setIssuedAt(new Date())
          .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
          .signWith(SignatureAlgorithm.HS512, jwtSecret)
          .compact();
    }
}
