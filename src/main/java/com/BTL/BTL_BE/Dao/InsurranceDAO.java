/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

import com.BTL.BTL_BE.entity.Insurrance;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author ACER
 */
@Repository
public class InsurranceDAO {
    @PersistenceContext
    private EntityManager emf;
    
    private Insurrance insurrance;
    
    public InsurranceDAO() {
        
    }
    
    public List<Object[]> find(int seri) {
        EntityManager entityManager = emf; 
        Query query = entityManager
            .createQuery("""
                         select c.idSeri, c.statusSeri, s.nameProduct, s.WarrantyPeriod, k.purchaseDate from Seri c join Product s on c.idProduct = 
                         s.IDProduct join InvoiceDetail u on u.idProduct = 
                         s.IDProduct join Invoice k on k.idVoice = 
                         u.idInvoice where c.idSeri =:seri""");
        
        query.setParameter("seri", seri);       
        
        return query.getResultList();
    }
}
