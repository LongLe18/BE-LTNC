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
@Table(name="ReceiptDetail")
public class ReceiptDetail {
    @Id
    @Column(name="ID_ReceiptDetail",nullable = false)
    private int idReceiptDetail;
    @Column(name="ID_Product",length = 50)
    private String idProduct;
    @Column(name="ID_Receipt")
    private int idReceipt;
    @Column(name="Price")
    private int price;

    public ReceiptDetail() {
    }

    public ReceiptDetail(int idReceiptDetail, String idProduct, int idReceipt, int price, int quantity) {
        this.idReceiptDetail = idReceiptDetail;
        this.idProduct = idProduct;
        this.idReceipt = idReceipt;
        this.price = price;
        this.quantity = quantity;
    }

    public void setIdReceiptDetail(int idReceiptDetail) {
        this.idReceiptDetail = idReceiptDetail;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public void setIdReceipt(int idReceipt) {
        this.idReceipt = idReceipt;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdReceiptDetail() {
        return idReceiptDetail;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public int getIdReceipt() {
        return idReceipt;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    @Column(name="Quantity")
    private int quantity;
}
