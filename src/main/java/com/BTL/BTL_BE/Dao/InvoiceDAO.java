/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

import com.BTL.BTL_BE.entity.Invoice;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nguye
 */
public interface InvoiceDAO extends JpaRepository<Invoice, Long> {
    List<Invoice> findAll();
    Invoice findByIdInvoice(String ID);
    List<Invoice> findBystatusOrder(int status);
    Invoice findTopByOrderByIdInvoiceDesc();
}
