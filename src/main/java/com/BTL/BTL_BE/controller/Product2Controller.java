package com.BTL.BTL_BE.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
import com.BTL.BTL_BE.Dao.ProductDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.BTL.BTL_BE.entity.Product;
import com.BTL.BTL_BE.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/Product")
public class Product2Controller {
    @Autowired
    ProductDAO productdao;
    
    @PostMapping("/AddProduct2")
    public ResponseEntity<MessageResponse> AddProduct(@ModelAttribute("pro") Product product)
    {
                    System.out.println(product.getID_Category());
        MessageResponse result = new MessageResponse();
        try {
            Product ExistProduct = productdao.findTopByOrderByIDProductDesc();
            Integer id= (Integer.parseInt(ExistProduct.getID_Product())+1);
            Product ProductInsert=new Product(id.toString(),product.getName_Product(),product.getImage(),product.getQuantity(),
                    product.getDescribe(),product.getPrice(),product.getSale(),product.getWarranty_Period(),
                    product.getID_Category(),product.getID_Brand(),product.getID_Season());
            productdao.save(ProductInsert);
            result.setData(ProductInsert);
            result.setMessage("Thêm sản phẩm thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }      
    }
}
