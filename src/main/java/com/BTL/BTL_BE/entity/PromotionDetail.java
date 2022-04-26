/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nguye
 */
@Entity
@Table(name="PromotionDetail")
//@IdClass(SampleEntity.class)
public class PromotionDetail implements Serializable {
    @Id
    @Column(name="ID_Product",length = 20,nullable = false)
    private String idProduct;
    @Id
    @Column(name="ID_Promotion")
    private int idPromotion;

    public PromotionDetail() {
    }

    public PromotionDetail(String idProduct, int idPromotion, int sale) {
        this.idProduct = idProduct;
        this.idPromotion = idPromotion;
        this.sale = sale;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public int getIdPromotion() {
        return idPromotion;
    }

    public int getSale() {
        return sale;
    }
    @Column(name="Sale")
    private int sale;
    
}
