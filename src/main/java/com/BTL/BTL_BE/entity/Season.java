/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.entity;

import java.util.Date;
//import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import org.thymeleaf.expression.Dates;


/**
 *
 * @author nguye
 */
@Entity
@Table(name="Season")
public class Season {
    @Id
    @Column(name = "ID_Season", nullable = false)
    private int id_Season;
    
    @Column(name = "Name_Season",length =50 , nullable = false)
    private String name_Season;
    
//    @Column(name="DateStart")
//    @Temporal(TemporalType.DATE) 
//    private Date dateStart;
//    
//    @Column(name="DateEnd")
//    @Temporal(TemporalType.DATE) 
//    private Date dateEnd;
//    
//    public Date getDateStart() {
//        return dateStart;
//    }
//
//    public Date getDateEnd() {
//        return dateEnd;
//    }
//    public void setDateStart(Date DateStart) {
//        this.dateStart = DateStart;
//    }
//
//    public void setDateEnd(Date DateEnd) {
//        this.dateEnd = DateEnd;
//    }
     public Season(int ID_Season, String Name_Season, Date DateStart, Date DateEnd) {
        this.id_Season = ID_Season;
        this.name_Season = Name_Season;
//        this.dateStart = DateStart;
//        this.dateEnd = DateEnd;
    }
    public void setID_Season(int ID_Season) {
        this.id_Season = ID_Season;
    }

    public void setName_Season(String Name_Season) {
        this.name_Season = Name_Season;
    }



    public int getID_Season() {
        return id_Season;
    }

    public String getName_Season() {
        return name_Season;
    }

//  

   

    public Season() {
    }
    
}
