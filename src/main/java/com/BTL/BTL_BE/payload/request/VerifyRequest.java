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

public class VerifyRequest {
    private final int code; // destination
    
    public VerifyRequest(@JsonProperty("code") int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    
}
