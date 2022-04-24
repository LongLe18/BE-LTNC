/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

/**
 *
 * @author ACER
 */
import javax.persistence.*;
import java.lang.Override;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "ID_Category", length = 20, nullable = false)
    private String ID_Product;
    private Category Danh_Muc;
    private String Name_Product;
    private String Image;
    private int Quantity;
    private String Describe;
    private int Price;
    private int Sale;
    private Brand Nhan_Hieu;
    private int Warranty_Period;

    public Product() {
    }

    public Product(String iD_Product, Category danh_Muc, String name_Product, String image, int quantity,
                    String describe, int price, int sale, Brand nhan_Hieu) {
            super();
            this.ID_Product = iD_Product;
            this.Danh_Muc = danh_Muc;
            this.Name_Product = name_Product;
            this.Image = image;
            this.Quantity = quantity;
            this.Describe = describe;
            this.Price = price;
            this.Sale = sale;
            this.Nhan_Hieu = nhan_Hieu;

    }
    public Product(String iD_Product, Category danh_Muc, String name_Product, String image, int quantity,
                    String describe, int price, int sale, Brand nhan_Hieu, int warranty_Period) {
            super();
            this.ID_Product = iD_Product;
            this.Danh_Muc = danh_Muc;
            this.Name_Product = name_Product;
            this.Image = image;
            this.Quantity = quantity;
            this.Describe = describe;
            this.Price = price;
            this.Sale = sale;
            this.Nhan_Hieu = nhan_Hieu;
            this.Warranty_Period = warranty_Period;

    }

    public Product(String iD_Product, String name_Product, String image, int price) {
            super();
            this.ID_Product = iD_Product;
            this.Name_Product = name_Product;
            this.Image = image;
            this.Price = price;


    }
    public String getID_Product() {
            return ID_Product;
    }

    public void setID_Product(String iD_Product) {
            this.ID_Product = iD_Product;
    }

    public Category getDanh_Muc() {
            return Danh_Muc;
    }

    public void setDanh_Muc(Category danh_Muc) {
            this.Danh_Muc = danh_Muc;
    }

    public String getName_Product() {
            return Name_Product;
    }

    public void setName_Product(String name_Product) {
            this.Name_Product = name_Product;
    }

    public String getImage() {
            return Image;
    }

    public void setImage(String image) {
            this.Image = image;
    }

    public int getQuantity() {
            return Quantity;
    }

    public void setQuantity(int quantity) {
            this.Quantity = quantity;
    }

    public String getDescribe() {
            return Describe;
    }

    public void setDescribe(String describe) {
            this.Describe = describe;
    }

    public int getPrice() {
            return Price;
    }

    public void setPrice(int price) {
            this.Price = price;
    }

    public int getSale() {
            return Sale;
    }

    public void setSale(int sale) {
            this.Sale = sale;
    }
    public Brand getNhan_Hieu() {
            return Nhan_Hieu;
    }

    public void setNhan_Hieu(Brand nhan_Hieu) {
            this.Nhan_Hieu = nhan_Hieu;
    }

    public int getWarranty_Period() {
            return Warranty_Period;
    }

    public void setWarranty_Period(int warranty_Period) {
            this.Warranty_Period = warranty_Period;
    }

}
