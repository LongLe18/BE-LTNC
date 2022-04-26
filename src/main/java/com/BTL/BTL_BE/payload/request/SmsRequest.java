/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.payload.request;

/**
 *
 * @author ACER
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class SmsRequest {
     @NotBlank
    private final String phoneNumber; // destination
    @NotBlank
    private final String password;
    
    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("password") String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
       
    public String getPassWord() {
        return password;
    }
    
    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +               
                '}';
    }
}
