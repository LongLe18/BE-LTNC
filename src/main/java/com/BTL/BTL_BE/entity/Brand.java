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
@Table(name = "Brand")
public class Brand {
    @Id
    @Column(name = "ID_Brand", length = 20, nullable = false)
    private String idBrand;
    
    @Column(name = "Name_Brand", length = 50)
    private String namebrand;
    
    @Column(name = "Country", length = 50)
    private String country;
    
    @Column(name= "Parent_Brand", length = 50)
    private String parentBrand;
    
    public String getIdBrand() {
        return idBrand;
    } 
    
    public void setIdBrand(String id) {
        this.idBrand = id;
    }
    
    public String getNameBrand() {
        return namebrand;
    }
    
    public void setNameBrand(String name) {
        this.namebrand = name;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String Country) {
        this.country = Country;
    }
    
    public String getParentBrand() {
        return parentBrand;
    }
    
    public void setParentBrand(String name) {
        this.parentBrand = name;
    }

    public Brand(String idBrand, String namebrand, String country, String parentBrand) {
        this.idBrand = idBrand;
        this.namebrand = namebrand;
        this.country = country;
        this.parentBrand = parentBrand;
    }

    public Brand() {
    }
}
