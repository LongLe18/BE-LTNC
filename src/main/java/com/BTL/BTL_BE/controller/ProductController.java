/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

/**
 *
 * @author ACER
 */
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BTL.BTL_BE.Dao.ProductDAO;
import com.BTL.BTL_BE.payload.response.MessageResponse;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductDAO productRepository;
    
    @GetMapping("/getproducts")
    public ResponseEntity<MessageResponse> getListParentCategory() {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productRepository.getList());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
}
