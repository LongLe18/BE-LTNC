/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nguye
 */
@Entity
@Table(name="ImageDetail")
public class ImageDetail {
    @Id
    @Column(name="ID_Image",nullable = false)
    private int ID_Image;
    @Column(name="Detail_Image",length = Integer.MAX_VALUE)
    private String Detail_Image;
    @Column(name="ID_Product",length = 20)
    private String ID_Product;
    @Column(name="Detail_Image1",length = Integer.MAX_VALUE)
    private String Detail_Image1;
    @Column(name="Detail_Image2",length = Integer.MAX_VALUE)
    private String Detail_Image2;

    public void setID_Image(int ID_Image) {
        this.ID_Image = ID_Image;
    }

    public void setDetail_Image(String Detail_Image) {
        this.Detail_Image = Detail_Image;
    }

    public void setID_Product(String ID_Product) {
        this.ID_Product = ID_Product;
    }

    public void setDetail_Image1(String Detail_Image1) {
        this.Detail_Image1 = Detail_Image1;
    }

    public void setDetail_Image2(String Detail_Image2) {
        this.Detail_Image2 = Detail_Image2;
    }

    public int getID_Image() {
        return ID_Image;
    }

    public String getDetail_Image() {
        return Detail_Image;
    }

    public String getID_Product() {
        return ID_Product;
    }

    public String getDetail_Image1() {
        return Detail_Image1;
    }

    public String getDetail_Image2() {
        return Detail_Image2;
    }

    public ImageDetail(int ID_Image, String Detail_Image, String ID_Product, String Detail_Image1, String Detail_Image2) {
        this.ID_Image = ID_Image;
        this.Detail_Image = Detail_Image;
        this.ID_Product = ID_Product;
        this.Detail_Image1 = Detail_Image1;
        this.Detail_Image2 = Detail_Image2;
    }
}
