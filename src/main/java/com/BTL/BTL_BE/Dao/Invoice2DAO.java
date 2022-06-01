/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

import com.BTL.BTL_BE.entity.Insurrance;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.BTL.BTL_BE.entity.Invoice2;
import java.util.Date;

/**
 *
 * @author ACER
 */
@Repository
public class Invoice2DAO {
    @PersistenceContext
    private EntityManager emf;
    
    private Insurrance insurrance;
    
    public Invoice2DAO() {
        
    }
    
    public List<Invoice2> find() {
        EntityManager entityManager = emf; 
        Query query = entityManager
            .createQuery("""
                         select a.idInvoice, b.userName, b.phone, b.address, a.paymentMethods, a.totalInvoice,
                         a.purchaseDate, a.statusOrder from Invoice a join AppUser b on a.idAccount = b.userId"""); 
        List<Object[]> rows = query.getResultList();
        List<Invoice2> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new Invoice2((String) row[0],
                                    (String) row[1],
                                    (String) row[2],
                                    (String) row[3],
                                    (String) row[4],
                                    (int) row[5],
                                    (Date) row[6],
                                    (int) row[7]));
        }
        
        return result;
    }
}
