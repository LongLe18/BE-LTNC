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
import com.BTL.BTL_BE.entity.Brand;
import com.BTL.BTL_BE.payload.response.MessageResponse;
import javax.validation.Valid;
import org.hibernate.validator.constraints.Length;

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
    @PostMapping("/AddBrand")
    public ResponseEntity<MessageResponse> AddBrand(@RequestBody Brand brand)
    {
        MessageResponse result = new MessageResponse();
        try {
            Brand ExistBrand=brandRepository.findTopByOrderByIdBrandDesc();
            String Id_Brand=ExistBrand.getIdBrand();
            Integer ID_Brand=Integer.parseInt(Id_Brand.substring(2,Id_Brand.length()))+1;
            Id_Brand=Id_Brand.substring(0,2)+ID_Brand.toString();
            
            Brand BrandInsert=new Brand(Id_Brand,brand.getNameBrand(),brand.getCountry(),brand.getParentBrand());
            brandRepository.save(BrandInsert);
            result.setData(BrandInsert);
            result.setMessage("Thêm nhãn hàng thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    @PutMapping("/ChangeBrand")
    public ResponseEntity<MessageResponse> ChangeProduct(@RequestParam(name="id") String ID,
  @Valid @RequestBody Brand brand)
    {
        MessageResponse result = new MessageResponse();
        try {
            Brand ExistBrand=brandRepository.findByIdBrand(ID).get(0);
            ExistBrand.setNameBrand(brand.getNameBrand());
            ExistBrand.setParentBrand(brand.getParentBrand());
            ExistBrand.setCountry(brand.getCountry());
            
            brandRepository.save(ExistBrand);
            result.setData(ExistBrand);
            result.setMessage("Thay đổi thông tin nhãn hàng thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    @DeleteMapping("/Delete")
    public ResponseEntity<MessageResponse> DeleteBrand(@RequestParam(name="id") String ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            Brand ExistBrand=brandRepository.findByIdBrand(ID).get(0);
//         
            brandRepository.delete(ExistBrand);
            result.setData(ExistBrand);
            result.setMessage("Xóa thông tin nhãn hàng thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    
}
