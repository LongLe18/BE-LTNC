/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author ACER
 */
public class Invoice2 implements Serializable{
    private String idInvoice;
    private String userName;
    private String phone;
    private String address;
    private String paymentMethods;
    private int totalInvoice;
    private Date purchaseDate;
    private int statusOrder;
    public Invoice2(String id, String username, String phone, String address, String payment, int total, Date date, int status) {
        this.idInvoice = id;
        this.userName = username;
        this.phone = phone;
        this.address = address;
        this.paymentMethods = payment;
        this.totalInvoice = total;
        this.purchaseDate = date;
        this.statusOrder = status;
    }
    
    public String getIdinvoice() {
        return idInvoice;
    }
    
    public void setIdinvoice(String id) {
        this.idInvoice = id;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String username) {
        this.userName = username;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPaymentMethods() {
        return paymentMethods;
    }
    
    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
    
    public int getTotalInvoice() {
        return totalInvoice;
    }
    
    public void setTotalInvoice(int totalInvoice) {
        this.totalInvoice = totalInvoice;
    }
    
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(Date date) {
        this.purchaseDate = date;
    }
    
    public int getStatusOrder() {
        return statusOrder;
    }
    
    public void setStatusOrder(int statusOrder) {
        this.statusOrder = statusOrder;
    }
}
