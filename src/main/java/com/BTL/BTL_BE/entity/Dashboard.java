/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

/**
 *
 * @author ACER
 */
public class Dashboard {
    private int quantity;
    private String idProduct;
    private String nameProduct;
    private int price;
    private int total;
    
    public Dashboard(int quantity, String id, String name, int price, int total) {
        this.quantity = quantity;
        this.idProduct = id;
        this.nameProduct = name;
        this.price = price;
        this.total = total;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quan) {
        this.quantity = quan;
    }
    
    public String getIdproduct() {
        return idProduct;
    }
    
    public void setIdproduct(String id) {
        this.idProduct = id;
    }
    
    public String getNameproduct() {
        return nameProduct;
    }
    
    public void setNameproduct(String name) {
        this.nameProduct = name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
}
