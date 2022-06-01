/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

/**
 *
 * @author ACER
 */
public class ReceiptDetail2 {
    private int idReceiptDetail;
    private String idProduct;    
    private String nameProduct;
    private int idReceipt;
    private int price;
    private int quantity;
    
    public ReceiptDetail2(int idReceiptDetail, String idProduct, String name, int idReceipt, int price, int quantity) {
        this.idProduct = idProduct;
        this.idReceiptDetail = idReceiptDetail;
        this.idReceipt = idReceipt;
        this.nameProduct = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public int getIdReceiptDetail() {
        return idReceiptDetail;
    }
    
    public void setIdReceiptDetail(int id) {
        this.idReceiptDetail = id;
    }
    
    public String getIdProduct() {
        return idProduct;
    }
    
    public void setIdProduct(String id) {
        this.idProduct = id;
    }
    
    public String getNameProduct() {
        return nameProduct;
    }
    
    public void setNameProduct(String name) {
        this.nameProduct = name;
    }
    
    public int getIdReceipt() {
        return idReceipt;
    }
    
    public void setIdReceipt(int id) {
        this.idReceipt = id;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
