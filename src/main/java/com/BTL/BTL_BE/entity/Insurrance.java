/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

/**
 *
 * @author ACER
 */
public class Insurrance {
    private int seri;
    private int statusSeri;
    private String nameProduct;
    private int WarrantyPeriod;
    private int purchaseDate;
    
    Insurrance(int seri, int status, String name, int period, int date) {
        this.seri = seri;
        this.statusSeri = status;
        this.nameProduct = name;
        this.WarrantyPeriod = period;
        this.purchaseDate = date;
    }
    
    Insurrance() {
    }
    
    public void setSeri(int seri) {
        this.seri = seri;
    }
    
    public void setStatusSeri(int status) {
        this.statusSeri = status;
    }
    
    public void setNameProduct(String name) {
        this.nameProduct = name;
    }
    
    public void setWarrantyPeriod(int WarrantyPeriod) {
        this.WarrantyPeriod = WarrantyPeriod;
    }
    
    public void setpurchaseDate(int purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
