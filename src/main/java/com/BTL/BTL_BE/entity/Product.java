/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

import java.util.*;
import javax.persistence.Lob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;


/**
 *
 * @author nguye
 */
@Entity
@Table(name="Product")
public class Product {
    @Id
    @Column(name="ID_Product",length = 20)
    private String IDProduct;
    @Column(name="Name_Product",length = 50)
    private String nameProduct;
    @Column(name="Image",length = 300)
    private String Image;
    
    @Column(name="Quantity")
    private int Quantity;
    @Column(name="Describe",length = 200)
    private String Describe;
    @Column(name="Price")
    private int Price;
    
    @Column(name="Sale")
    private int sale;
    
    @Column(name="Warranty_Period")
    private int WarrantyPeriod;
    @Column(name="ID_Category",length = 20)
    private String IDCategory;
    @Column(name="ID_Brand",length = 20)
    private String IDBrand;
    @Column(name="ID_Season")
    private int IDSeason;
    
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private Collection<ImageDetail> imageDetails;
    
    public void setID_Product(String ID_Product) {
        this.IDProduct = ID_Product;
    }

    public void setName_Product(String Name_Product) {
        this.nameProduct = Name_Product;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setDescribe(String Describe) {
        this.Describe = Describe;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setSale(int Sale) {
        this.sale = Sale;
    }

    public void setWarranty_Period(int Warranty_Period) {
        this.WarrantyPeriod = Warranty_Period;
    }

    public void setID_Category(String ID_Category) {
        this.IDCategory = ID_Category;
    }

    public void setID_Brand(String ID_Brand) {
        this.IDBrand = ID_Brand;
    }

    public void setID_Season(int ID_Season) {
        this.IDSeason = ID_Season;
    }

    public String getID_Product() {
        return IDProduct;
    }

    public String getName_Product() {
        return nameProduct;
    }

    public String getImage() {
        return Image;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getDescribe() {
        return Describe;
    }

    public int getPrice() {
        return Price;
    }

    public int getSale() {
        return sale;
    }

    public int getWarranty_Period() {
        return WarrantyPeriod;
    }

    public String getID_Category() {
        return IDCategory;
    }

    public String getID_Brand() {
        return IDBrand;
    }

    public int getID_Season() {
        return IDSeason;
    }


    public Product(String ID_Product, String Name_Product, String Image, int Quantity, String Describe, int Price, int Sale, 
            int Warranty_Period, String ID_Category, String ID_Brand, int ID_Season) {
        this.IDProduct = ID_Product;
        this.nameProduct = Name_Product;
        this.Image = Image;
        this.Quantity = Quantity;
        this.Describe = Describe;
        this.Price = Price;
        this.sale = Sale;
        this.WarrantyPeriod = Warranty_Period;
        this.IDCategory = ID_Category;
        this.IDBrand = ID_Brand;
        this.IDSeason = ID_Season;
    }
    public Product( ) {
       
    }
    
}
