/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

import com.BTL.BTL_BE.Dao.ProductDAO;
import com.BTL.BTL_BE.Dao.ImagedetailDAO;
import com.BTL.BTL_BE.Dao.InsurranceDAO;
import com.BTL.BTL_BE.Dao.Product2DAO;
import com.BTL.BTL_BE.entity.Product;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @Autowired
    Product2DAO productdao2;
    
    @Autowired
    ImagedetailDAO imagedetailDao;
    
    @Autowired
    InsurranceDAO insurranceDao;
    
    @GetMapping("/getImageDetail")
    public ResponseEntity<MessageResponse> GetImageDetail(@RequestParam(name="id") String ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(imagedetailDao.findByProductsIDProduct(ID));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
       
    @GetMapping("/search")
    public ResponseEntity<MessageResponse> Search(@RequestParam(name="idbrand") String idbrand, 
            @RequestParam(name="idcate") String idcate, @RequestParam(name="idseason") String idseason, 
            @RequestParam(name="describe") String describe)
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productdao.Search(idbrand, idcate, idseason, describe));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getProductFastly")
    public ResponseEntity<MessageResponse> getProductFastly()
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(productdao2.getListProduct());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
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
    public ResponseEntity<MessageResponse> GetProductByID_Brand(@RequestParam(name="id_Brand") String ID,
            @RequestParam(name="pageSize") int pageSize, @RequestParam(name="pageIndex") int pageIndex)
    {
        MessageResponse result = new MessageResponse();
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        try {
            result.setData(productdao.findByIDBrand(ID, pageable));
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
    public ResponseEntity<MessageResponse> GetSaleProduct()
    {
        MessageResponse result = new MessageResponse();
        try {
            List<Product> arr = productdao.findBySaleGreaterThan(0);
            result.setData(arr);
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    
    @GetMapping("/getInsurrenceBySeri/{seri}")
    public ResponseEntity<MessageResponse> GetInsurrance(@PathVariable int seri)
    {
        MessageResponse result = new MessageResponse();
        try {
            List<Object[]> arr = insurranceDao.find(seri);
            result.setData(arr);
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    } 
    @PostMapping("/AddProduct")
    public ResponseEntity<MessageResponse> AddProduct(@RequestBody Product product)
    {
        MessageResponse result = new MessageResponse();
        try {
            Product ExistProduct=productdao.findTopByOrderByIDProductDesc();
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
    @PutMapping("/ChangeProduct")
    public ResponseEntity<MessageResponse> ChangeProduct(@RequestParam(name="id") String ID,
            @Valid @RequestBody Product product)
    {
        MessageResponse result = new MessageResponse();
        try {
            Product ExistProduct=productdao.findByIDProduct(ID).get(0);
//            Integer id= (Integer.parseInt(ExistProduct.getID_Product())+1);
//            Product ProductInsert=new Product(id.toString(),product.getName_Product(),product.getImage(),product.getQuantity(),
//                    product.getDescribe(),product.getPrice(),product.getSale(),product.getWarranty_Period(),
//                    product.getID_Category(),product.getID_Brand(),product.getID_Season());
            ExistProduct.setDescribe(product.getDescribe());
            ExistProduct.setID_Brand(product.getID_Brand());
            ExistProduct.setID_Season(product.getID_Season());
            ExistProduct.setImage(product.getImage());
            ExistProduct.setName_Product(product.getName_Product());
            ExistProduct.setPrice(product.getPrice());
            ExistProduct.setQuantity(product.getQuantity());
            ExistProduct.setSale(product.getSale());
            ExistProduct.setWarranty_Period(product.getWarranty_Period());
            ExistProduct.setID_Category(product.getID_Category());
            productdao.save(ExistProduct);
            result.setData(ExistProduct);
            result.setMessage("Thay đổi sản phẩm thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    @DeleteMapping("/Delete")
    public ResponseEntity<MessageResponse> DeleteProduct(@RequestParam(name="id") String ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            Product ExistProduct=productdao.findByIDProduct(ID).get(0);
//         
            productdao.delete(ExistProduct);
//            result.setData(ExistProduct);
            result.setMessage("Xóa sản phẩm thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
}
