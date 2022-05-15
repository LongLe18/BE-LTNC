/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

/**
 *
 * @author ACER
 */
import com.BTL.BTL_BE.entity.Invoice;
import com.BTL.BTL_BE.entity.InvoiceDetail;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PaymentDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    private Invoice invoice;
    
    private InvoiceDetail invoicedetail;
    
    @Transactional
    public void insertInvoiceWithQuery(Invoice invoice) {
        entityManager.persist(invoice);      
    }
    
    @Transactional
    public void insertInvoiceDetailWithQuery(InvoiceDetail invoicedetail) {
        entityManager.persist(invoicedetail);
    }
}
