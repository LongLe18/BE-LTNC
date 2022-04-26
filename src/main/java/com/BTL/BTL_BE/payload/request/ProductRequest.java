/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.payload.request;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author nguye
 */
public class ProductRequest {
    @NotBlank
    private String ID_Product;

    public void setID(String ID) {
        this.ID_Product = ID_Product;
    }

    public ProductRequest(String ID_Product) {
        this.ID_Product = ID_Product;
    }

    public String getID() {
        return ID_Product;
    }

    public ProductRequest() {
    }
    
}
