/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

/**
 *
 * @author ACER
 */
import java.util.Date;
import java.util.ArrayList;
import com.BTL.BTL_BE.Dao.ShipperDAO;
import com.BTL.BTL_BE.Dao.InvoiceDAO;
import com.BTL.BTL_BE.Dao.ProductDAO;
import com.BTL.BTL_BE.Dao.PaymentDAO;

import com.BTL.BTL_BE.entity.Payment;
import com.BTL.BTL_BE.entity.Invoice;
import com.BTL.BTL_BE.entity.InvoiceDetail;
import com.BTL.BTL_BE.entity.Product;
import com.BTL.BTL_BE.entity.ProductCheckout;
import com.BTL.BTL_BE.entity.Shipper;

import com.BTL.BTL_BE.payload.response.MessageResponse;
import java.util.Random;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/checkout")
public class PaymentController {
    @Autowired
    ShipperDAO shipperdao;
    
    @Autowired
    InvoiceDAO invoicedao;
    
    @Autowired
    ProductDAO productdao;
    
    @Autowired
    PaymentDAO paymentdao;
    
    @GetMapping("/getShipper")
    public ResponseEntity<MessageResponse> GetShipper(@RequestParam(name="id") int ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(shipperdao.findByidShipper(ID));
            result.setMessage("Th??nh c??ng");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("L???i " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    @PostMapping("/AddShipper")
    public ResponseEntity<MessageResponse> AddShipper(@RequestBody Shipper shipper)
    {
        MessageResponse result = new MessageResponse();
        try {
            Shipper ExistShipper=shipperdao.findTopByOrderByIdShipperDesc();
//            Integer id= (Integer.parseInt(ExistProduct.getID_Product())+1);
            Shipper ShipperInsert=new Shipper(ExistShipper.getIdShipper()+1,ExistShipper.getNameShipper(),ExistShipper.getPhoneShipper(),ExistShipper.getCompanyShipper());
            shipperdao.save(ShipperInsert);
            result.setData(ShipperInsert);
            result.setMessage("Th??m ng?????i giao h??ng th??nh c??ng");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("L???i " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    @PutMapping("/ChangeShipper")
    public ResponseEntity<MessageResponse> ChangeProduct(@RequestParam(name="id") int ID,
  @Valid @RequestBody Shipper shipper)
    {
        MessageResponse result = new MessageResponse();
        try {
            Shipper ExistShipper=shipperdao.findByidShipper(ID).get(0);
            ExistShipper.setCompanyShipper(shipper.getCompanyShipper());
            ExistShipper.setNameShipper(shipper.getNameShipper());
            ExistShipper.setPhoneShipper(shipper.getPhoneShipper());
            
            shipperdao.save(ExistShipper);
            result.setData(ExistShipper);
            result.setMessage("Thay ?????i th??ng tin ng?????i giao h??ng th??nh c??ng");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("L???i " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    @DeleteMapping("/Delete")
    public ResponseEntity<MessageResponse> DeleteProduct(@RequestParam(name="id") int ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            Shipper ExistShipper=shipperdao.findByidShipper(ID).get(0);
//         
            shipperdao.delete(ExistShipper);
            result.setData(ExistShipper);
            result.setMessage("X??a th??ng tin ng?????i giao h??ng th??nh c??ng");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("L???i " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    
    @PostMapping("/checkout")
    public ResponseEntity<MessageResponse> PostPayment(@RequestBody Payment payment) {
        MessageResponse result = new MessageResponse();
        Date date = new Date();
        Random rd = new Random();
        int n = 234363123;
        try {
            String mhd = "MHD" + date.getTime();
            /* NOTE: Th???c hi???n ki???m tra ??i???u ki???n ??? FE */
            if (payment.getIdAccount().isBlank() || payment.getAddress().isBlank() || payment.getMethod().isBlank() || payment.getTotal() == 0) {
                result.setStatus(MessageResponse.Status.FAILED);
                result.setMessage("Th??ng tin ?????t h??ng c??n tr???ng");
                return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
            } else {
                Invoice invoice = new Invoice(mhd, payment.getIdAccount(), payment.getAddress(), payment.getMethod(), date, 2, payment.getTotal(), payment.getIdShipper(),
                    "0", new Date(date.getTime() + (1000 * 60 * 60 * 24 * 3)));
                // insert record to invoice
                paymentdao.insertInvoiceWithQuery(invoice);
            }
            
            // insert record to invoicedetail
            if (!payment.getProducts().isEmpty()) {
                for (ProductCheckout product: payment.getProducts()) {
                    // Check s??? l?????ng c??n so v???i s??? l?????ng mua
                    if (productdao.findByIDProduct(product.getidProduct()).get(0).getQuantity() < product.getQuantity()) {
                        result.setStatus(MessageResponse.Status.FAILED);
                        result.setMessage("S??? l?????ng s???n ph???m " + productdao.findByIDProduct(product.getidProduct()).get(0).getName_Product() + " kh??ng ?????");
                        return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
                    }   
                    int mhdct = rd.nextInt(n);
                    int total = (product.getPrice() - product.getSale()) * product.getQuantity();
                    InvoiceDetail detail = new InvoiceDetail(mhdct, mhd, product.getidProduct(), 
                            product.getQuantity(), product.getPrice(), product.getSale(), total);
                    paymentdao.insertInvoiceDetailWithQuery(detail);
                    
                    // update quantity to product
                    Product one = productdao.findByIDProduct(product.getidProduct()).get(0);
                    if(one != null) one.setQuantity(one.getQuantity() - product.getQuantity());
                    productdao.save(one);
                }
            } else {
                result.setStatus(MessageResponse.Status.FAILED);
                result.setMessage("Danh s??ch s???n ph???m tr???ng");
                return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
            }                    
            result.setStatus(MessageResponse.Status.SUCCESS);
            result.setMessage("?????t h??ng th??nh c??ng");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("L???i " + e);        
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
