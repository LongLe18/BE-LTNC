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
@Table(name="Shipper")
public class Shipper {
    @Id
    @Column(name="ID_Shipper",nullable = false)
    private int idShipper;

    public Shipper() {
    }

    public Shipper(int idShipper, String nameShipper, String phoneShipper, String companyShipper) {
        this.idShipper = idShipper;
        this.nameShipper = nameShipper;
        this.phoneShipper = phoneShipper;
        this.companyShipper = companyShipper;
    }

    public void setIdShipper(int idShipper) {
        this.idShipper = idShipper;
    }

    public void setNameShipper(String nameShipper) {
        this.nameShipper = nameShipper;
    }

    public void setPhoneShipper(String phoneShipper) {
        this.phoneShipper = phoneShipper;
    }

    public void setCompanyShipper(String companyShipper) {
        this.companyShipper = companyShipper;
    }

    public int getIdShipper() {
        return idShipper;
    }

    public String getNameShipper() {
        return nameShipper;
    }

    public String getPhoneShipper() {
        return phoneShipper;
    }

    public String getCompanyShipper() {
        return companyShipper;
    }
    @Column(name="Name_Shipper",length = 50)
    private String nameShipper;
    @Column(name="Phone_Shipper",length = 50)
    private String phoneShipper;
    @Column(name="Company_Shipper",length = 50)
    private String companyShipper;
    
}
