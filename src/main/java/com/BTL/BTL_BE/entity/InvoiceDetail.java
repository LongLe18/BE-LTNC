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
@Table(name="InvoiceDetail")
public class InvoiceDetail {
    @Id
    @Column(name="ID_InvoiceDetail",nullable = false)
    private int idInvoiceDetail;
    @Column(name="ID_Invoice",length = 20)
    private String idInvoice;
    @Column(name="ID_Product",length = 20)
    private String idProduct;
    @Column(name="Quantity")
    private int quantity; 
//    @Column(name="Purchase_Date",columnDefinition = Date)
//    @Temporal(TemporalType.DATE) 
//    private Date Image;
    @Column(name="Price")
    private int statusOrder;
    @Column(name="Sale")
    private int sale;

    public InvoiceDetail() {
    }

    public InvoiceDetail (int idInvoiceDetail, String idInvoice, String idProduct, int quantity, int statusOrder, int sale, int total) {
        this.idInvoiceDetail = idInvoiceDetail;
        this.idInvoice = idInvoice;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.statusOrder = statusOrder;
        this.sale = sale;
        this.total = total;
    }

    public void setIdInvoiceDetail(int idInvoiceDetail) {
        this.idInvoiceDetail = idInvoiceDetail;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatusOrder(int statusOrder) {
        this.statusOrder = statusOrder;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdInvoiceDetail() {
        return idInvoiceDetail;
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStatusOrder() {
        return statusOrder;
    }

    public int getSale() {
        return sale;
    }

    public int getTotal() {
        return total;
    }
    @Column(name="Total")
    private int total;
}
