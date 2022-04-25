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

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "ID_Product", length = 20, nullable = false)
    private String ID_Product;
    
    @Column(name = "ID_Category", length = 20)
    private String Danh_Muc;
    
    @Column(name = "Name_Product", length = 50)
    private String Name_Product;
    
    @Column(name = "Image", length = 1000)
    private String Image;
    
    @Column(name = "Quantity")
    private int Quantity;
    
    @Column(name = "Describe", length = 200)
    private String Describe;
    
    @Column(name = "Price")
    private int Price;
    
    @Column(name = "Sale")
    private int Sale;
    
    @Column(name = "ID_Brand", length = 20)
    private String ID_Brand;
    
    @Column(name = "Warranty_Period")
    private int Warranty_Period;
    
    @Column(name = "ID_Season")
    private int ID_Season;
    
    public Product() {
    }
    
    public Product(String iD_Product, String danh_Muc, String name_Product, String image, int quantity,
			String describe, int price, int sale, String ID_Brand, int Warranty_Period, int ID_Season) {
        this.ID_Product = iD_Product;
        this.Danh_Muc = danh_Muc;
        this.Name_Product = name_Product;
        this.Image = image;
        this.Quantity = quantity;
        this.Describe = describe;
        this.Price = price;
        this.Sale = sale;
        this.ID_Brand = ID_Brand;
        this.Warranty_Period = Warranty_Period;
        this.ID_Season = ID_Season;
    }
    
    
    public String getID_Product() {
        return ID_Product;
    }

    public void setID_Product(String iD_Product) {
        this.ID_Product = iD_Product;
    }

    public String getDanh_Muc() {
        return Danh_Muc;
    }

    public void setDanh_Muc(String danh_Muc) {
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
    
    public String getIDBrand() {
        return ID_Brand;
    }

    public void setIDBrand(String nhan_Hieu) {
        this.ID_Brand = nhan_Hieu;
    }

    public int getWarranty_Period() {
        return Warranty_Period;
    }

    public void setWarranty_Period(int warranty_Period) {
        this.Warranty_Period = warranty_Period;
    }
    
    public int getID_Season() {
        return ID_Season;
    }
    
    public void setID_Season(int ID_Season) {
        this.ID_Season = ID_Season;
    }
}
