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
public class StatusProduct {
    @Id
    @Column(name="ID_StatusProduct",nullable = false)
    private int idStatusProduct;
    @Column(name="Name_Status",length = 50)
    private String nameStatus;
    @Column(name="Repair_Time")
    private int repairTime;

    public int getIdStatusProduct() {
        return idStatusProduct;
    }

    public StatusProduct() {
    }

    public StatusProduct(int idStatusProduct, String nameStatus, int repairTime) {
        this.idStatusProduct = idStatusProduct;
        this.nameStatus = nameStatus;
        this.repairTime = repairTime;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public int getRepairTime() {
        return repairTime;
    }

    public void setIdStatusProduct(int idStatusProduct) {
        this.idStatusProduct = idStatusProduct;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    public void setRepairTime(int repairTime) {
        this.repairTime = repairTime;
    }
    
}
