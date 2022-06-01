/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class addReceipt {
    private String idAccount;
    private int total;
    private ArrayList<ProductInput> products;
    
    public String getIdAccount() {
        return idAccount;
    }
    
    public void setIdAccount(String id) {
        this.idAccount = id;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public ArrayList<ProductInput> getProducts() {
        return products;
    }
    
    public void setProducts(ArrayList<ProductInput> products) {
        this.products = products;
    }
}
