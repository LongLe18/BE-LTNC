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
    private Integer idSeri;
    @Column(name="Status_Seri")
    private Integer statusSeri;

    public Seri() {
    }

    public Seri(Integer idSeri, Integer statusSeri, String idProduct, Integer idReceiptDetail, Integer idInvoiceDetail) {
        this.idSeri = idSeri;
        this.statusSeri = statusSeri;
        this.idProduct = idProduct;
        this.idReceiptDetail = idReceiptDetail;
        this.idInvoiceDetail = idInvoiceDetail;
    }

    public void setIdSeri(Integer idSeri) {
        this.idSeri = idSeri;
    }

    public void setStatusSeri(Integer statusSeri) {
        this.statusSeri = statusSeri;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public void setIdReceiptDetail(Integer idReceiptDetail) {
        this.idReceiptDetail = idReceiptDetail;
    }

    public void setIdInvoiceDetail(Integer idInvoiceDetail) {
        this.idInvoiceDetail = idInvoiceDetail;
    }

    public Integer getIdSeri() {
        return idSeri;
    }

    public Integer getStatusSeri() {
        return statusSeri;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public Integer getIdReceiptDetail() {
        return idReceiptDetail;
    }

    public Integer getIdInvoiceDetail() {
        return idInvoiceDetail;
    }
    @Column(name="ID_Product",length = 20)
    private String idProduct;
    @Column(name="ID_ReceiptDetail")
    private Integer idReceiptDetail;
    @Column(name="ID_InvoiceDetail")
    private Integer idInvoiceDetail;
}
