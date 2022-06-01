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

import com.BTL.BTL_BE.Dao.WarrantyDAO;
import com.BTL.BTL_BE.payload.response.MessageResponse;
import com.BTL.BTL_BE.entity.Warranty;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/warranty")
public class WarrantyController {
    @Autowired
    WarrantyDAO warrantyRepository;   
    
    @GetMapping("/getWarranty")
    public ResponseEntity<MessageResponse> getAllAds() {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(warrantyRepository.findAll());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getWarranty/{ID_Warranty}")
    public ResponseEntity<MessageResponse> getWarranty (@PathVariable int ID_Warranty) {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(warrantyRepository.findByidWarranty(ID_Warranty));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @PutMapping("/ChangeWarranty")
    public ResponseEntity<MessageResponse> ChangeWarranty(@RequestParam(name="id") int ID,
            @Valid @RequestBody Warranty warranty)
    {
        MessageResponse result = new MessageResponse();
        try {
            Warranty ExistWarrenty = warrantyRepository.findByidWarranty(ID);
            ExistWarrenty.setStatus(warranty.getStatus());
            ExistWarrenty.setReturnDate(warranty.getReturnDate());            
      
            warrantyRepository.save(ExistWarrenty);
            result.setData(ExistWarrenty);
            result.setMessage("Thay đổi bảo hành thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
}
