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
@Table(name="Seri")
public class Seri {
    @Id
    @Column(name="id_seri",nullable = false)
    private int idSeri;
    @Column(name="Status_Seri")
    private int statusSeri;

    public Seri() {
    }

    public Seri(int idSeri, int statusSeri, String idProduct, int idReceiptDetail, int idInvoiceDetail) {
        this.idSeri = idSeri;
        this.statusSeri = statusSeri;
        this.idProduct = idProduct;
        this.idReceiptDetail = idReceiptDetail;
        this.idInvoiceDetail = idInvoiceDetail;
    }

    public void setIdSeri(int idSeri) {
        this.idSeri = idSeri;
    }

    public void setStatusSeri(int statusSeri) {
        this.statusSeri = statusSeri;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public void setIdReceiptDetail(int idReceiptDetail) {
        this.idReceiptDetail = idReceiptDetail;
    }

    public void setIdInvoiceDetail(int idInvoiceDetail) {
        this.idInvoiceDetail = idInvoiceDetail;
    }

    public int getIdSeri() {
        return idSeri;
    }

    public int getStatusSeri() {
        return statusSeri;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public int getIdReceiptDetail() {
        return idReceiptDetail;
    }

    public int getIdInvoiceDetail() {
        return idInvoiceDetail;
    }
    @Column(name="ID_Product",length = 20)
    private String idProduct;
    @Column(name="ID_ReceiptDetail")
    private int idReceiptDetail;
    @Column(name="ID_InvoiceDetail")
    private int idInvoiceDetail;
}
