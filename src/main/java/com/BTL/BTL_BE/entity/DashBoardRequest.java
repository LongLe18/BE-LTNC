/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

/**
 *
 * @author ACER
 */
public class DashBoardRequest {
    private String from;
    private String to;
    public DashBoardRequest(String from, String to) {
        this.from = from;
        this.to = to;
    }
    
    public String getFrom() {
        return from;
    }
    
    public void setFrom(String from ){
        this.from = from;
    }
    
    public String getTo() {
        return to;
    }
    
    public void setTo(String to) {
        this.to = to;
    }
}
