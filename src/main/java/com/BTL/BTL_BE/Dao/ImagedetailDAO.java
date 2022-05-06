/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

/**
 *
 * @author ACER
 */

import com.BTL.BTL_BE.entity.ImageDetail;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ImagedetailDAO extends JpaRepository<ImageDetail, Long>{
    
    List<ImageDetail> findByProductsIDProduct(String IDProduct);
}
