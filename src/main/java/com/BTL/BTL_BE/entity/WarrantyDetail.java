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
@Table(name="WarrantyDetail")
public class WarrantyDetail implements Serializable{
    @Id
    @Column(name="ID_Warranty",nullable = false)
    private int idWarranty;
    @Id
    @Column(name="ID_StatusProduct",nullable = false)
    private int idStatusProduct;

    public int getIdWarranty() {
        return idWarranty;
    }

    public int getIdStatusProduct() {
        return idStatusProduct;
    }

    public void setIdWarranty(int idWarranty) {
        this.idWarranty = idWarranty;
    }

    public void setIdStatusProduct(int idStatusProduct) {
        this.idStatusProduct = idStatusProduct;
    }

    public WarrantyDetail(int idWarranty, int idStatusProduct) {
        this.idWarranty = idWarranty;
        this.idStatusProduct = idStatusProduct;
    }

    public WarrantyDetail() {
    }
    
}
