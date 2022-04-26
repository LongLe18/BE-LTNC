/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

import com.BTL.BTL_BE.entity.Category;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nguye
 */
@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {
    List<Category> findAll();
    @Query("SELECT u FROM Category u WHERE u.Parent_Category='null'")
    ArrayList<Category> getListParentCategory();
    
    //load danh sach danh muc con
    @Query("SELECT u FROM Category u WHERE u.Parent_Category=?1")
    ArrayList<Category> getListSubCategory(String ID_Category);
}
