/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author nguye
 */
@Entity
@Table(name="Receipt")
public class Receipt {
    @Id
    @Column(name="ID_Receipt", nullable = true)
    private int idReceipt;
    
    @Column(name="ID_Account",length=20)
    private String idAccount;
    
    @Column(name="Created_date")
    @Temporal(TemporalType.DATE) 
    private Date createdDate;
    
    @Column(name="total")
    private int total;
    
    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date date) {
        this.createdDate = date;
    }
    
    public int getIdReceipt() {
        return idReceipt;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public int getTotal() {
        return total;
    }

    public void setIdReceipt(int idReceipt) {
        this.idReceipt = idReceipt;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Receipt(int id, String idAccount, Date date,int total) {
        this.idReceipt = id;
        this.idAccount = idAccount;
        this.createdDate = date;
        this.total = total;
    }

    public Receipt() {
    }

   
}
