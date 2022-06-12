/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

/**
 *
 * @author ACER
 */
import com.BTL.BTL_BE.entity.ReceiptDetail;
import com.BTL.BTL_BE.entity.Dashboard;

import java.util.Date;
import java.text.SimpleDateFormat;  
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.BTL.BTL_BE.entity.ReceiptDetail2;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TemporalType;
@Repository
public class ReceiptDetailDAO {
    @PersistenceContext
    private EntityManager emf;
    
    public ReceiptDetailDAO() {
        
    }
    
    public List<ReceiptDetail2> find(int idReceipt) {
        EntityManager entityManager = emf; 
        Query query = entityManager
            .createQuery("""
                         select b.idReceiptDetail, b.idProduct, c.nameProduct, a.idReceipt, b.price, b.quantity
                         from Receipt a join ReceiptDetail b on a.idReceipt = b.idReceipt 
                         join Product c on b.idProduct = c.IDProduct where a.idReceipt =:idReceipt"""); 
        query.setParameter("idReceipt", idReceipt); 
        
        List<Object[]> rows = query.getResultList();
        List<ReceiptDetail2> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new ReceiptDetail2((int) row[0],
                                    (String) row[1],
                                    (String) row[2],
                                    (int) row[3],
                                    (int) row[4],
                                    (int) row[5]));
        }
        
        return result;
    }
    
    @Transactional
    public void insertInvoiceWithQuery(ReceiptDetail detail) {
        emf.persist(detail);      
    }
       
    @Transactional
    public void Delete(int idReceipt) {
        EntityManager entityManager = emf; 
        Query query = entityManager.createQuery("delete from ReceiptDetail where idReceipt=:idReceipt");
        query.setParameter("idReceipt", idReceipt);
        query.executeUpdate();
    }
    
    public List<Dashboard> getDashboard(String from, String to) {
        EntityManager entityManager = emf; 
        Query query = entityManager
               .createQuery(""" 
                            select SUM(b.quantity), b.idProduct, c.nameProduct, c.Price, SUM(a.totalInvoice)
                            from Invoice a join InvoiceDetail b on a.idInvoice = b.idInvoice
                            join Product c on b.idProduct = c.IDProduct
                            where a.statusOrder = 1 and a.purchaseDate > :from and a.purchaseDate < :to
                            GROUP BY b.idProduct, c.nameProduct, c.Price
                            """);
        try {
            query.setParameter("from", new SimpleDateFormat("yyyy-MM-dd").parse(from), TemporalType.DATE);        
            query.setParameter("to", new SimpleDateFormat("yyyy-MM-dd").parse(to), TemporalType.DATE);
        } catch (Exception e) {
            System.out.print(e);
        }
        

        List<Object[]> rows = query.getResultList();
        List<Dashboard> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            Long temp1 = (Long) row[0];
            int count = temp1.intValue();
            Long temp3 = (Long) row[4];
            int count3 = temp3.intValue();
            result.add(new Dashboard(count, (String) row[1], (String) row[2], (int) row[3], count3));
        }
        return result;
    }
    
    public List<Dashboard> getDashboard2(String idCate) {
        EntityManager entityManager = emf; 
        Query query = entityManager
               .createQuery(""" 
                            select SUM(b.quantity), b.idProduct, c.nameProduct, c.Price, SUM(a.totalInvoice)
                            from Invoice a join InvoiceDetail b on a.idInvoice = b.idInvoice
                            join Product c on b.idProduct = c.IDProduct
                            where a.statusOrder = 1 and c.IDCategory =:idcate
                            GROUP BY b.idProduct, c.nameProduct, c.Price
                            """);

        query.setParameter("idcate", idCate);        

        List<Object[]> rows = query.getResultList();
        List<Dashboard> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            Long temp1 = (Long) row[0];
            int count = temp1.intValue();
            Long temp3 = (Long) row[4];
            int count3 = temp3.intValue();
            result.add(new Dashboard(count, (String) row[1], (String) row[2], (int) row[3], count3));
        }
        return result;
    }
    
}
