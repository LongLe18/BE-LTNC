/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

import com.BTL.BTL_BE.Dao.InvoiceDAO;
import com.BTL.BTL_BE.Dao.SeasonDAO;
import com.BTL.BTL_BE.entity.Invoice;
import com.BTL.BTL_BE.entity.Season;
import com.BTL.BTL_BE.payload.response.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/api/Invoice")
public class InvoiceController {
    @Autowired
    InvoiceDAO invoicedao;
    @GetMapping("/getInvoice")
    public ResponseEntity<MessageResponse> GetAllInvoice()
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(invoicedao.findAll());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    @GetMapping("/getInvoiceByID")
    public ResponseEntity<MessageResponse> GetInvoiceByID(@RequestParam(name="id") String ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(invoicedao.findByIdInvoice(ID));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    @GetMapping("/getInvoiceByStatus")
    public ResponseEntity<MessageResponse> GetInvoiceByStatus(@RequestParam(name="status") int ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(invoicedao.findBystatusOrder(ID));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    @PostMapping("/AddInvoice")
    public ResponseEntity<MessageResponse> AddInvoice(@RequestBody Invoice invoice)
    {
        MessageResponse result = new MessageResponse();
        try {
//            Brand ExistBrand=brandRepository.findTopByOrderByIdBrandDesc();
//            String Id_Brand=ExistBrand.getIdBrand();
//            Integer ID_Brand=Integer.parseInt(Id_Brand.substring(2,Id_Brand.length()))+1;
//            Id_Brand=Id_Brand.substring(0,2)+ID_Brand.toString();
            
            Invoice ExistInvoice=invoicedao.findTopByOrderByIdInvoiceDesc();
            String Id_Invoice=ExistInvoice.getIdVoice();
            long ID_Invoice=Long.parseLong(Id_Invoice.substring(3,Id_Invoice.length()))+1;
            Id_Invoice=Id_Invoice.substring(0,3)+Long.toString(ID_Invoice);
            Date today=new Date();
            Invoice InvoiceInsert=new Invoice(Id_Invoice,invoice.getIdAccount(),invoice.getShippingAddress(),invoice.getPaymentMethods(),
//            java.time.LocalDate.now(),
                    new Date(today.getTime()),
                    invoice.getStatusOrder(),invoice.getTotalInvoice(),invoice.getIdShipper(),invoice.getIdEmployee(),
                    new java.util.Date(today.getTime()+(1000 * 60 * 60 * 24)));
//                    java.time.LocalDate.now().plusDays(3));
            invoicedao.save(InvoiceInsert);
            result.setData(InvoiceInsert);
            result.setMessage("Thêm hóa đơn thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
//    @PutMapping("/ChangeProduct")
//    public ResponseEntity<MessageResponse> ChangeProduct(@RequestParam(name="id") String ID,
//  @Valid @RequestBody Product product)
//    {
//        MessageResponse result = new MessageResponse();
//        try {
//            Product ExistProduct=productdao.findByIDProduct(ID).get(0);
////            Integer id= (Integer.parseInt(ExistProduct.getID_Product())+1);
////            Product ProductInsert=new Product(id.toString(),product.getName_Product(),product.getImage(),product.getQuantity(),
////                    product.getDescribe(),product.getPrice(),product.getSale(),product.getWarranty_Period(),
////                    product.getID_Category(),product.getID_Brand(),product.getID_Season());
//            ExistProduct.setDescribe(product.getDescribe());
//            ExistProduct.setID_Brand(product.getID_Brand());
//            ExistProduct.setID_Season(product.getID_Season());
//            ExistProduct.setImage(product.getImage());
//            ExistProduct.setName_Product(product.getName_Product());
//            ExistProduct.setPrice(product.getPrice());
//            ExistProduct.setQuantity(product.getQuantity());
//            ExistProduct.setSale(product.getSale());
//            ExistProduct.setWarranty_Period(product.getWarranty_Period());
//            ExistProduct.setID_Category(product.getID_Category());
//            productdao.save(ExistProduct);
//            result.setData(ExistProduct);
//            result.setMessage("Thay đổi sản phẩm thành công");
//            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
//        } catch(Exception e) {
//            result.setStatus(MessageResponse.Status.FAILED);
//            result.setMessage("Lỗi " + e);
//                
//            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
//        }    
//    }  
//    @DeleteMapping("/Delete")
//    public ResponseEntity<MessageResponse> DeleteProduct(@RequestParam(name="id") String ID)
//    {
//        MessageResponse result = new MessageResponse();
//        try {
//            Product ExistProduct=productdao.findByIDProduct(ID).get(0);
////         
//            productdao.delete(ExistProduct);
////            result.setData(ExistProduct);
//            result.setMessage("Xóa sản phẩm thành công");
//            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
//        } catch(Exception e) {
//            result.setStatus(MessageResponse.Status.FAILED);
//            result.setMessage("Lỗi " + e);
//                
//            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
//        }    
//    }  
    
    
}
