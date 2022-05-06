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
        
@Entity(name = "ImageDetail")
@Table(name="ImageDetail")
public class ImageDetail {
    @Id
    @Column(name="ID_Image",nullable = false)
    private int IDImage;
    
    @Column(name="Detail_Image",length = 2000)
    private String DetailImage;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_Product", nullable = false)
    private Product products;
    
    @Column(name="Detail_Image1",length = 2000)
    private String DetailImage1;
    
    @Column(name="Detail_Image2",length = 2000)
    private String DetailImage2;

    public void setIDImage(int IDImage) {
        this.IDImage = IDImage;
    }

    public void setDetailImage(String DetailImage) {
        this.DetailImage = DetailImage;
    }

//    public void setIDProduct(String IDProduct) {
//        this.IDProduct = IDProduct;
//    }

    public void setDetailImage1(String DetailImage1) {
        this.DetailImage1 = DetailImage1;
    }

    public void setDetailImage2(String DetailImage2) {
        this.DetailImage2 = DetailImage2;
    }

    public int getIDImage() {
        return IDImage;
    }

    public String getDetailImage() {
        return DetailImage;
    }

//    public String getIDProduct() {
//        return IDProduct;
//    }

    public String getDetail_Image1() {
        return DetailImage1;
    }

    public String getDetailImage2() {
        return DetailImage2;
    }
    
    public ImageDetail() {
        
    }
    
    public ImageDetail(int IDImage, String DetailImage, String IDProduct, String DetailImage1, String DetailImage2) {
        this.IDImage = IDImage;
        this.DetailImage = DetailImage;
//        this.IDProduct = IDProduct;
        this.DetailImage1 = DetailImage1;
        this.DetailImage2 = DetailImage2;
    }
}

