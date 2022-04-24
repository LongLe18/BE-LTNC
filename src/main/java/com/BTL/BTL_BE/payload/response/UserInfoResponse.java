/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.payload.response;

/**
 *
 * @author ACER
 */
import java.util.List;

public class UserInfoResponse {
    private String token;
    private String id;
    private String username;
    private String email;
    private List<String> roles;

    public UserInfoResponse(String token, String id, String username, String email, List<String> roles) {
            this.token = token;
            this.id = id;
            this.username = username;
            this.email = email;
            this.roles = roles;
    }
    
    public String getToken() {
            return token;
    }

    public void setToken(String token) {
            this.token = token;
    }
    
    public String getId() {
            return id;
    }

    public void setId(String id) {
            this.id = id;
    }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getUsername() {
            return username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public List<String> getRoles() {
            return roles;
    }
}