/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

import java.util.ArrayList;
import com.BTL.BTL_BE.entity.ProductCheckout;
/**
 *
 * @author ACER
 */
public class Payment {
    private String idAccount;
    private String address;
    private String method;
    private int total;
    private int idShipper;
    private ArrayList<ProductCheckout> products;
    
    public String getIdAccount() {
        return idAccount;
    }
    
    public void setIdAccount(String id) {
        this.idAccount = id;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String add) {
        this.address = add;
    }
    
    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public int getIdShipper() {
        return idShipper;
    }
    
    public void setIdShipper(int id) {
        this.idShipper = id;
    }
    
    public ArrayList<ProductCheckout> getProducts() {
        return products;
    }
    
    public void setProducts(ArrayList<ProductCheckout> products) {
        this.products = products;
    }
}
