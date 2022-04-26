/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;
import java.util.Date;
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
@Table(name="Promotion")
public class Promotion {
    @Id
    @Column(name="ID_Promotion",nullable = false)
    private int idPromotion;

    public Promotion() {
    }

    public Promotion(int idPromotion, String idAccount, String Reason) {
        this.idPromotion = idPromotion;
        this.idAccount = idAccount;
        this.reason = Reason;
    }
    
//    @Column(name="DateStart")
//    @Temporal(TemporalType.DATE) 
//    private Date dateStart;
//    @Column(name="DateEnd")
//    @Temporal(TemporalType.DATE) 
//    private Date dateEnd;
    @Column(name="ID_Account",length = 20)
    private String idAccount; 
//    @Column(name="Purchase_Date",columnDefinition = Dates)
//    @Temporal(TemporalType.DATE) 
//    private Dates Image;
    @Column(name="Reason",length = 100)
    private String reason;

    public int getIdPromotion() {
        return idPromotion;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public String getReason() {
        return reason;
    }

    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public void setReason(String Reason) {
        this.reason = Reason;
    }
   
}
