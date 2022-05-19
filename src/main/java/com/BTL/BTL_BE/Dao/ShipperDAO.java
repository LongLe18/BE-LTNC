/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

import com.BTL.BTL_BE.entity.Product;
import com.BTL.BTL_BE.entity.Shipper;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author ACER
 */
@Repository
public interface ShipperDAO extends JpaRepository<Shipper, Long>{
    List<Shipper> findByidShipper(int IDSeasion);
    Shipper findTopByOrderByIdShipperDesc();
}
