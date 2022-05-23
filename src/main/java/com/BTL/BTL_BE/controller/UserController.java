/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BTL.BTL_BE.entity.*;
import com.BTL.BTL_BE.payload.request.*;
import com.BTL.BTL_BE.payload.response.*;
import com.BTL.BTL_BE.Dao.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    AppUserDAO userRepository;
    @Autowired
    AppRoleDAO roleRepository;
    @Autowired
    PasswordEncoder encoder;
    
    @GetMapping("/getUsers")
    public ResponseEntity<MessageResponse> getAllUsers() {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(userRepository.findAll());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @PostMapping("/addUser")
    public ResponseEntity<MessageResponse> createUser(@RequestBody SignupRequest signUpRequest  ) {
        if (userRepository.existsByuserName(signUpRequest.getUsername())) {
            MessageResponse result = new MessageResponse();
            result.setMessage("Tên người dùng đã tồn tại");
            result.setStatus(MessageResponse.Status.FAILED);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByemail(signUpRequest.getEmail())) {
            MessageResponse result = new MessageResponse();
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Email đã được sử dụng!");
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
        result.setMessage("Đăng ký thành công");
        return new ResponseEntity<MessageResponse>(result, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/info")
    public ResponseEntity<MessageResponse> getUser(@RequestParam(name="id") String ID) {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(userRepository.findByuserId(ID));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }   
    }
    
    @PutMapping("/updateUser")
    public ResponseEntity<MessageResponse> updateUser(@RequestBody AppUser user) {
        Optional<AppUser> userDetail = userRepository.findByuserId(user.getUserId());
        MessageResponse result = new MessageResponse();
        if (userDetail.isPresent()) {
            AppUser OldUser = userDetail.get();
            ///update user
            OldUser.setName(user.getName());
            OldUser.setAddress(user.getAddress());
            OldUser.setphone(user.getphone());
            OldUser.setUserName(user.getUserName());
            OldUser.setAuth(user.getAuth());
            OldUser.setEmail(user.getEmail());
            OldUser.setAcess(user.getAcess());
            OldUser.setRoles(user.getRoles());
            
            result.setStatus(MessageResponse.Status.SUCCESS);
            result.setMessage("Cập nhật thông tin thành công");
            result.setData(userRepository.save(OldUser));
            return new ResponseEntity<MessageResponse>(result, HttpStatus.ACCEPTED);
        } else {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Cập nhật thông tin không thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
