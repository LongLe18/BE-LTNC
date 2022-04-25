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
import com.BTL.BTL_BE.entity.Product;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
    @Query("SELECT u FROM Product u WHERE u.Quantity >=0 ORDER BY u.ID_Product DESC")
    ArrayList<Product> getList();
}
