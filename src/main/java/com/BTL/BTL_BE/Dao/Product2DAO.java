/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

/**
 *
 * @author ACER
 */
import com.BTL.BTL_BE.entity.Product2;
import java.util.Date;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TemporalType;

@Repository
public class Product2DAO {
    @PersistenceContext
    private EntityManager emf;
    
    public Product2DAO() {
        
    }
    
    public List<Product2> getListProduct() {
        EntityManager entityManager = emf; 
        Query query = entityManager
            .createQuery("""
                         select a.idProduct, sum(a.quantity), b.nameProduct, b.Price, b.sale, b.Quantity, b.Image
                         from InvoiceDetail a join Product b on a.idProduct = b.IDProduct 
                         group by a.idProduct, b.nameProduct, b.Price, b.sale, b.Quantity, b.Image
                         order by sum(a.quantity) desc"""); 
        query.setMaxResults(10);
        List<Object[]> rows = query.getResultList();
        
        List<Product2> result = new ArrayList<>(rows.size());
        
        for (Object[] row : rows) {
            Long temp1 = (Long) row[1];
            int count = temp1.intValue();
            result.add(new Product2((String) row[0],
                                    count,
                                    (String) row[2],
                                    (int) row[3],
                                    (int) row[4],
                                    (int) row[5],
                                    (String) row[6]));
        }
        
        return result;
    }
}
