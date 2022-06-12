/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

/**
 *
 * @author ACER
 */
public class Product2 {
    private String IDProduct;
    private int numberProductSaled;
    private String nameProduct;
    private int price;
    private int sale;
    private int quantity;
    private String Image;
    
    public Product2(String id, int number, String name, int price, int sale, int quan, String img) {
        this.IDProduct = id;
        this.numberProductSaled = number;
        this.nameProduct = name;
        this.price = price;
        this.sale = sale;
        this.quantity = quan;
        this.Image = img;
    }
    
    public Product2(int quantity, String idProduct, String nameProduct, int price, int sale) {
        this.quantity = quantity;
        this.IDProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.sale = sale;
    }
    
    public String getIdProduct() {
        return IDProduct;
    } 
    
    public void setIdProduct(String id) {
        this.IDProduct = id;
    }
    
    public int getNumberSaled() {
        return numberProductSaled;
    }
    
    public void setNumberSaled(int number) {
        this.numberProductSaled = number;
    }
    
    public String getNameProduct() {
        return nameProduct;
    }
    
    public void setNameProduct(String name) {
        this.nameProduct = name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getSale() {
        return sale;
    }
    
    public void setSale(int sale) {
        this.sale = sale;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quan) {
        this.quantity = quan;
    }
    
    public String getImage() {
        return Image;
    }
    
    public void setImage(String img) {
        this.Image = img;
    }
    
}
