/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

/**
 *
 * @author ACER
 */
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.BTL.BTL_BE.entity.*;
import com.BTL.BTL_BE.payload.request.*;
import com.BTL.BTL_BE.payload.response.*;
import com.BTL.BTL_BE.Dao.*;
import com.BTL.BTL_BE.security.jwt.JwtUtils;
import com.BTL.BTL_BE.service.UserDetailsImpl;
import java.util.*;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AppUserDAO userRepository;
    @Autowired
    AppRoleDAO roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    
    public static String JWT;
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<AppUser> account = userRepository.findByemail(loginRequest.getEmail());
        String username = account.get().getUserName();
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        
        JWT = jwtCookie.toString();
        
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(jwtCookie.toString(), userDetails.getId(),
                                       userDetails.getUsername(),
                                       userDetails.getEmail(),
                                       roles));
    }
    
    @GetMapping("/info")
    public ResponseEntity<?> getInfoUser() {
        try {
            if (JWT == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                String jwt = Arrays.asList(Arrays.asList(JWT.split(";")).get(0).split("=")).get(1);
                String UserId = jwtUtils.getIdFromJwtToken(jwt);
                Optional<AppUser> userDetails = userRepository.findByuserId(UserId); 
                return ResponseEntity.ok()
                    .body(userDetails);
            }        
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/user/{id}/{confirm}")
    public ResponseEntity<MessageResponse> updateUser(@PathVariable("id") String id, @RequestBody AppUser user, 
            @PathVariable("confirm") String confirm) {
        Optional<AppUser> userDetail = userRepository.findByuserId(id);
        MessageResponse result = new MessageResponse();
        if (userDetail.isPresent()) {
            AppUser OldUser = userDetail.get();
            if (encoder.matches(confirm, OldUser.getPassword())) {
                OldUser.setPassword(encoder.encode(user.getPassword()));
            } else {
                result.setStatus(MessageResponse.Status.FAILED);
                result.setMessage("M???t kh???u x??c th???c kh??ng ????ng");
                return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
            }
            OldUser.setName(user.getName());
            OldUser.setAddress(user.getAddress());
            OldUser.setphone(user.getphone());
            result.setStatus(MessageResponse.Status.SUCCESS);
            result.setMessage("C???p nh???t th??ng tin th??nh c??ng");
            result.setData(userRepository.save(OldUser));
            return new ResponseEntity<MessageResponse>(result, HttpStatus.ACCEPTED);
        } else {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("C???p nh???t th??ng tin kh??ng th??nh c??ng");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/user/{id}/{status}")
    public ResponseEntity<MessageResponse> changeAuth(@PathVariable("id") String id, @PathVariable("status") String status) {
        Optional<AppUser> userDetail = userRepository.findByuserId(id);
        MessageResponse result = new MessageResponse();
        if (userDetail.isPresent()) { 
            AppUser OldUser = userDetail.get();
            if (status.equals("1")) {
                OldUser.setAuth(true);
            } else {
                OldUser.setAuth(false);
            }
            userRepository.save(OldUser);
            result.setStatus(MessageResponse.Status.SUCCESS);
            result.setMessage("C???p nh???t th??ng tin th??nh c??ng");
            result.setData(userRepository.save(OldUser));
            return new ResponseEntity<MessageResponse>(result, HttpStatus.ACCEPTED);
        } else {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("C???p nh???t th??ng tin kh??ng th??nh c??ng");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByuserName(signUpRequest.getUsername())) {
            MessageResponse result = new MessageResponse();
            result.setMessage("T??n ng?????i d??ng ???? t???n t???i");
            result.setStatus(MessageResponse.Status.FAILED);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByemail(signUpRequest.getEmail())) {
            MessageResponse result = new MessageResponse();
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Email ???? ???????c s??? d???ng!");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }
        // Create new user's account
        Date id = new Date();
        String mtk = "KH" + id.getTime();
        AppUser user = new AppUser(mtk, signUpRequest.getUsername(),
                             signUpRequest.getEmail(),
                             encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();      
        Set<AppRole> roles = new HashSet<>();
        if (strRoles == null) {
            AppRole userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        } else {
          strRoles.forEach(role -> {
            switch (role) {
            case "admin":
                AppRole adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(adminRole);
                break;
            case "mod":
                AppRole modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(modRole);
                break;
            default:
                AppRole userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(userRole);
            }
          });
        }
        user.setAcess(2);
        user.setStatus(1);
        user.setRoles(roles);
        userRepository.save(user);
        MessageResponse result = new MessageResponse();
        result.setMessage("????ng k?? th??nh c??ng");
        return new ResponseEntity<MessageResponse>(result, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        MessageResponse result = new MessageResponse();
        result.setMessage("????ng xu???t th??nh c??ng");
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
            .body(new ResponseEntity<MessageResponse>(result, HttpStatus.ACCEPTED));
    }      
}
