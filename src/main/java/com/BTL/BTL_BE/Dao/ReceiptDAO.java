package com.BTL.BTL_BE.Dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */

import com.BTL.BTL_BE.entity.Receipt;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReceiptDAO extends JpaRepository<Receipt, Long> {
    Receipt findByidReceipt(int id);
}
