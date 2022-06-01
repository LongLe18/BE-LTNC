/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

/**
 *
 * @author ACER
 */
public class ProductInput {
    private String id_Product;
    private int quantity;
    private int price;
    
    public void setidProduct(String id) {
        this.id_Product = id;
    }
    
    public String getidProduct() {
        return id_Product;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
}
