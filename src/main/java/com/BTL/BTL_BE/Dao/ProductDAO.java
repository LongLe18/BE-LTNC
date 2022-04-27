/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

import com.BTL.BTL_BE.entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author nguye
 */
@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
//    Optional<Product> findbyID_Product();
//    List<Product> findAll();
    @Query("SELECT u FROM Product u WHERE u.Quantity >=0 ORDER BY u.IDProduct DESC")
    ArrayList<Product> getList();
    
    @Query("SELECT u FROM Product u WHERE u.Quantity >=0 ORDER BY u.IDProduct DESC")
    ArrayList<Product> getListProductByPages(Pageable pageable);
    
    List<Product> findByIDCategory(String IDCategory, Pageable pageable);
    List<Product> findByIDProduct(String IDProduct);
    List<Product> findByIDBrand(String IDBrand);
    List<Product> findByIDSeason(int IDSeasion);
    List<Product> findByNameProduct(String Name);
}
