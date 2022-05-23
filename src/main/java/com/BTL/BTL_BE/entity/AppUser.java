/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

/**
 *
 * @author ACER
 */
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Account", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "Username") })
public class AppUser {
    @Id
    @Column(name = "ID_Account", length = 20, nullable = false)
    private String userId;
    
    @Column(name = "Username", length = 50)
    private String userName;
    
    @Column(name = "Password", length = 120, nullable = false)
    private String password;

    @Column(name = "auth", nullable = true)
    private Boolean auth = false;
    
    @Column(name = "Email", length = 50)
    private String email;
    
    @Column(name = "Full_name", length = 50)
    private String fullname;
    
    @Column(name = "Address", length = 50)
    private String address;
    
    @Column(name = "SDT", length = 50)
    private String phone;
    
    @Column(name = "Access")
    private int access;
    
    @Column(name = "Status")
    private int status;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "UserRole", 
             joinColumns = @JoinColumn(name = "ID_Account"),
             inverseJoinColumns = @JoinColumn(name = "RoleID"))
    private Set<AppRole> roles = new HashSet<>();
    
    ////////////////////////////////////////////////
    public AppUser() {
    }
    
    public AppUser(String id, String username, String email, String password) {
        this.userId = id;
        this.userName = username;
        this.email = email;
        this.password = password;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return fullname;
    }

    public void setName(String name) {
        this.fullname = name;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }
    
    public int getAcess() {
        return access;
    }

    public void setAcess(int access) {
        this.access = access;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public Set<AppRole> getRoles() {
        return roles;
    }
    public void setRoles(Set<AppRole> roles) {
      this.roles = roles;
    }
  
}
