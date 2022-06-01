/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

import com.BTL.BTL_BE.entity.Receipt;
import com.BTL.BTL_BE.entity.ReceiptDetail;
import com.BTL.BTL_BE.entity.addReceipt;
import com.BTL.BTL_BE.entity.ProductInput;
import com.BTL.BTL_BE.entity.Product;
import com.BTL.BTL_BE.entity.DashBoardRequest;

import com.BTL.BTL_BE.Dao.ReceiptDAO;
import com.BTL.BTL_BE.Dao.ReceiptDetailDAO;
import com.BTL.BTL_BE.Dao.ProductDAO;

import com.BTL.BTL_BE.payload.response.MessageResponse;
import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Receipt")
public class ReceiptController {
    @Autowired
    ReceiptDAO receiptrepository;
       
    @Autowired
    ReceiptDetailDAO receiptdetailrepository;
    
    @Autowired
    ProductDAO productdao;
    
    @PostMapping("/dashboard")
    public ResponseEntity<MessageResponse> Dashboard(@RequestBody DashBoardRequest dashboard)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(receiptdetailrepository.getDashboard(dashboard.getFrom(), dashboard.getTo()));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getReceipt")
    public ResponseEntity<MessageResponse> GetAllReceipts()
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(receiptrepository.findAll());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getReceiptByID")
    public ResponseEntity<MessageResponse> GetReceiptByID(@RequestParam(name="id") int ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(receiptrepository.findByidReceipt(ID));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
       
    @GetMapping("/getReceiptDetailByID")
    public ResponseEntity<MessageResponse> GetDetailReceiptByID(@RequestParam(name="id") int ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(receiptdetailrepository.find(ID));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @PostMapping("/addRecepit")
    public ResponseEntity<MessageResponse> AddReceipt(@RequestBody addReceipt recepit) {
        MessageResponse result = new MessageResponse();
        Random rd = new Random();
        int n = 234363123;
        Date today=new Date();
        try {
            int idReceipt = rd.nextInt(n);
            if (recepit.getIdAccount().isBlank() || recepit.getTotal() == 0) {
                result.setStatus(MessageResponse.Status.FAILED);
                result.setMessage("Thông tin nhập hàng còn trống");
                return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
            } else {
                Receipt newrecepit = new Receipt(idReceipt, recepit.getIdAccount(), new Date(today.getTime()), recepit.getTotal());
                receiptrepository.save(newrecepit);
            }
                 
            // insert record to receiptdetail
            if (!recepit.getProducts().isEmpty()) {
                for (ProductInput product: recepit.getProducts()) {  
                    int idDetail = rd.nextInt(n);
                    int total = product.getPrice() * product.getQuantity();
                    ReceiptDetail detail = new ReceiptDetail(idDetail, product.getidProduct(), idReceipt, 
                            total, product.getQuantity());
                    receiptdetailrepository.insertInvoiceWithQuery(detail);
                    
                    // update quantity to product
                    Product one = productdao.findByIDProduct(product.getidProduct()).get(0);
                    if(one != null) one.setQuantity(one.getQuantity() + product.getQuantity());
                    productdao.save(one);
                }
            } else {
                result.setStatus(MessageResponse.Status.FAILED);
                result.setMessage("Danh sách sản phẩm trống");
                return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
            }  
            result.setMessage("Thêm phiếu nhập thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/Delete")
    public ResponseEntity<MessageResponse> DeleteInvoice(@RequestParam(name="id") int ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            Receipt ExistReceipt=receiptrepository.findByidReceipt(ID);
            receiptdetailrepository.Delete(ID);

            receiptrepository.delete(ExistReceipt);
            result.setData(ExistReceipt);
            result.setMessage("Xóa phiếu nhập thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    
    
}
