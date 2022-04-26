/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.thymeleaf.expression.Dates;

/**
 *
 * @author nguye
 */

@Entity
@Table(name="Invoice")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Invoice implements Serializable {
    @Id
    @Column(name="ID_Invoice",length = 20,nullable = false)
    private String idVoice;
    @Column(name="ID_Account",length = 20)
    private String idAccount;
    @Column(name="Shipping_Address",length = 50)
    private String shippingAddress;
    @Column(name="Payment_Methods",length = 50)
    private String paymentMethods; 
//    @Column(name="Purchase_Date",columnDefinition = Dates)
//    @Temporal(TemporalType.DATE) 
//    private Dates Image;
    @Column(name="Status_Order")
    private int statusOrder;
    @Column(name="Total_Invoice")
    private String totalInvoice;
    @Column(name="ID_Shipper")
    private Integer idShipper;

    public Invoice() {
    }

    public Invoice(String idVoice, String idAccount, String shippingAddress, String paymentMethods, int statusOrder, String totalInvoice, Integer idShipper, String idEmployee) {
        this.idVoice = idVoice;
        this.idAccount = idAccount;
        this.shippingAddress = shippingAddress;
        this.paymentMethods = paymentMethods;
        this.statusOrder = statusOrder;
        this.totalInvoice = totalInvoice;
        this.idShipper = idShipper;
        this.idEmployee = idEmployee;
    }

    public void setIdVoice(String idVoice) {
        this.idVoice = idVoice;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void setStatusOrder(int statusOrder) {
        this.statusOrder = statusOrder;
    }

    public void setTotalInvoice(String totalInvoice) {
        this.totalInvoice = totalInvoice;
    }

    public void setIdShipper(Integer idShipper) {
        this.idShipper = idShipper;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getIdVoice() {
        return idVoice;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getPaymentMethods() {
        return paymentMethods;
    }

    public int getStatusOrder() {
        return statusOrder;
    }

    public String getTotalInvoice() {
        return totalInvoice;
    }
    @JsonIgnoreProperties
    public Integer getIdShipper() {
        return idShipper;
    }

    public String getIdEmployee() {
        return idEmployee;
    }
    @Column(name="ID_Employee",length = 20)
    private String idEmployee;
//    @Column(name="Purchase_Date",columnDefinition = Dates)
//    @Temporal(TemporalType.DATE) 
//    private Dates Image;

    public Invoice(String idVoice, String idAccount, String shippingAddress, String paymentMethods, int statusOrder, String totalInvoice, String idEmployee) {
        this.idVoice = idVoice;
        this.idAccount = idAccount;
        this.shippingAddress = shippingAddress;
        this.paymentMethods = paymentMethods;
        this.statusOrder = statusOrder;
        this.totalInvoice = totalInvoice;
        this.idEmployee = idEmployee;
    }
    
}