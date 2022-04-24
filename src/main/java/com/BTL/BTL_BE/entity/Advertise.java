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
@Table(name = "Advertise")
public class Advertise {
    @Id
    @Column(name = "ID_Ads", nullable = false)
    private int idAds;
    
    @Column(name = "Image_Ads", length = 300)
    private String ImageAds;
    
    //////////////
    public Advertise() {
    }
    
    public Advertise(int id, String image) {
        this.idAds = id;
        this.ImageAds = image;
    }
    
    public int getIdAds() {
        return idAds;
    }
    
    public void setIdAds(int id) {
        this.idAds = id;
    }
    
    public String getImageAds() {
        return ImageAds;
    }
    
    public void setImageAds(String image) {
        this.ImageAds = image;
    }
}
