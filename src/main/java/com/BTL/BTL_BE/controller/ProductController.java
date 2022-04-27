/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

import com.BTL.BTL_BE.Dao.ProductDAO;
import com.BTL.BTL_BE.entity.Product;
import com.BTL.BTL_BE.payload.request.LoginRequest;
import com.BTL.BTL_BE.payload.request.ProductRequest;
import com.BTL.BTL_BE.payload.response.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author nguye
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Product")
public class ProductController {
    @Autowired
    ProductDAO productdao;
    
    @GetMapping("/getProduct")
    public ResponseEntity<MessageResponse> GetAllProduct()
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productdao.findAll());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    @GetMapping("/getproducts")
    public ResponseEntity<MessageResponse> getListProducts() {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productdao.getList());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getproducts/{pageSize}/{pageIndex}")
    public ResponseEntity<MessageResponse> getListProductByPages(@PathVariable int pageSize, @PathVariable int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productdao.getListProductByPages(pageable));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    @GetMapping("/getProductByID")
//    public ResponseEntity<MessageResponse> GetProductByID(@Valid @RequestBody ProductRequest productRequest)
            public ResponseEntity<MessageResponse> GetProductByID(@RequestParam(name="id") String ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productdao.findByIDProduct(ID));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    @GetMapping("/getProductByIDBrand")
//    public ResponseEntity<MessageResponse> GetProductByID(@Valid @RequestBody ProductRequest productRequest)
    public ResponseEntity<MessageResponse> GetProductByID_Brand(@RequestParam(name="id_Brand") String ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productdao.findByIDBrand(ID));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    @GetMapping("/getProductByIDSeason")
//    public ResponseEntity<MessageResponse> GetProductByID(@Valid @RequestBody ProductRequest productRequest)
    public ResponseEntity<MessageResponse> GetProductByID_Season(@RequestParam(name="id_Season") int ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productdao.findByIDSeason(ID));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    @GetMapping("/getProductByProductName")
//    public ResponseEntity<MessageResponse> GetProductByID(@Valid @RequestBody ProductRequest productRequest)
    public ResponseEntity<MessageResponse> GetProductByProductName(@RequestParam(name="ProductName") String Name)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productdao.findByNameProduct(Name));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getProductByCategory")
    public ResponseEntity<MessageResponse> GetProductByCategory(@RequestParam(name="IDCategory") String id,
            @RequestParam(name="pageSize") int pageSize, @RequestParam(name="pageIndex") int pageIndex)
    {
        MessageResponse result = new MessageResponse();
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        try {
            result.setData(productdao.findByIDCategory(id, pageable));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getSaleProduct")
//    public ResponseEntity<MessageResponse> GetProductByID(@Valid @RequestBody ProductRequest productRequest)
    public ResponseEntity<MessageResponse> GetSaleProduct()
    {
        MessageResponse result = new MessageResponse();
        try {
            List<Product> arr=productdao.findAll();
            List<Product> arr2=new ArrayList<Product>();
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i).getSale() !=0)
                {
                    arr2.add(arr.get(i));
                }
            }
            result.setData(arr2);
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
        
}
