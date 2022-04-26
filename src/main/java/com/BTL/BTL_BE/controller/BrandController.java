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

import com.BTL.BTL_BE.Dao.BrandDAO;
import com.BTL.BTL_BE.payload.response.MessageResponse;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    BrandDAO brandRepository;
    
//    @GetMapping("/getBrand")
//    public ResponseEntity<MessageResponse> getAllAds() {
//        MessageResponse result = new MessageResponse();
//        try {
//            result.setData(brandRepository.findAll());
//            result.setMessage("Thành công");
//            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
//        } catch(Exception e) {
//            result.setStatus(MessageResponse.Status.FAILED);
//            result.setMessage("Lỗi " + e);
//            
//            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
//        }    
//    }
    @GetMapping("/getBrand")
    public ResponseEntity<MessageResponse> getAllAds() {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(brandRepository.findAll());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getParentBrand")
    public ResponseEntity<MessageResponse> getListParentBrand() {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(brandRepository.getListParentBrand());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getSubBrand/{ID_Brand}")
    public ResponseEntity<MessageResponse> getListSubBrand(@PathVariable String ID_Brand) {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(brandRepository.getListSubBrand(ID_Brand));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
}
