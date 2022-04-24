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

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @Column(name = "ID_Category", length = 20, nullable = false)
    private String ID_Category;
    
    @Column(name = "Name_Category", length = 50)
    private String Name_Category;
    
    @Column(name = "Parent_Category", length = 50)
    private String Parent_Category;

    public Category() {
    }

    public Category(String iD_Category, String name_Category, String parent_Category) {
        this.ID_Category = iD_Category;
        this.Name_Category = name_Category;
        this.Parent_Category = parent_Category;
    }

    public String getID_Category() {
            return ID_Category;
    }

    public void setID_Category(String iD_Category) {
            this.ID_Category = iD_Category;
    }

    public String getName_Category() {
            return Name_Category;
    }

    public void setName_Category(String name_Category) {
            this.Name_Category = name_Category;
    }

    public String getParent_Category() {
            return Parent_Category;
    }

    public void setParent_Category(String parent_Category) {
            this.Parent_Category = parent_Category;
    }
}
