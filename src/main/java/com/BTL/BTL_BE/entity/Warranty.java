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
import java.util.Date;

@Entity
@Table(name = "Warranty")
public class Warranty {
    @Id
    @Column(name = "ID_Warranty", nullable = false)
    private int idWarranty;
    
    @Column(name = "Received_Date")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    
    @Column(name = "Return_Date")
    @Temporal(TemporalType.DATE)   
    private Date returnDate;
    
    @Column(name= "Intend_Time", length=50)
    private String intendTime;
    
    @Column(name= "Status")
    private int status;
    
    @Column(name= "id_seri")
    private int idSeri;
    //////////////
    public Warranty() {
    }
    
    public Warranty(int idWar, Date receivedDate, Date returnDate, String intendTime, int status, int idseri) {
        this.idWarranty = idWar;
        this.receivedDate = receivedDate;
        this.returnDate = returnDate;
        this.intendTime = intendTime;
        this.status = status;
        this.idSeri = idseri;
    }
    
    public int getIdWarranty() {
        return idWarranty;
    }
    
    public void setIdWarranty(int id) {
        this.idWarranty = id;
    }
    
    public Date getReceivedDate() {
        return receivedDate;
    }
    
    public void setReceivedDate(Date date) {
        this.receivedDate = date;
    }
    
    public Date getReturnDate() {
        return returnDate;
    }
    
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    public String getIntendTime() {
        return intendTime;
    }
    
    public void setIntendTime(String time) {
        this.intendTime = time;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getIdSeri() {
        return idSeri;
    }
    
    public void setIdSeri(int id) {
        this.idSeri = id;
    }
}
