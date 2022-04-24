/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

/**
 *
 * @author ACER
 */
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BTL.BTL_BE.entity.Brand;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface BrandDAO extends JpaRepository<Brand, Long>{
    List<Brand> findAll();
    
    @Query("SELECT u FROM Brand u WHERE u.parentBrand='null'")
    ArrayList<Brand> getListParentBrand();
    
    @Query("SELECT u FROM Brand u WHERE u.parentBrand=?1")
    ArrayList<Brand> getListSubBrand(String ID_Brand);
}
