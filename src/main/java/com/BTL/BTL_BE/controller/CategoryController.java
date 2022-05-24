/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

import com.BTL.BTL_BE.Dao.BrandDAO;
import com.BTL.BTL_BE.Dao.CategoryDAO;
import com.BTL.BTL_BE.entity.Category;
import com.BTL.BTL_BE.entity.Product;
import com.BTL.BTL_BE.payload.response.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    CategoryDAO categorydao;
    
    @GetMapping("/getCategorys")
    public ResponseEntity<MessageResponse> getAllCategory() {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(categorydao.findAll());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    @GetMapping("/getCategoryName")
    public ResponseEntity<MessageResponse> getCategoryName() {
        MessageResponse result = new MessageResponse();
        try {
            List<Category> arr = categorydao.findAll();
            List<String> arr2=new ArrayList<String>();
            
            for(int i=0;i<arr.size();i++)
            {
                arr2.add(arr.get(i).getName_Category());
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
    @GetMapping("/getCategory")
    public ResponseEntity<MessageResponse> getListParentCategory() {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(categorydao.getListParentCategory());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @GetMapping("/getSubCategory/{ID_Category}")
    public ResponseEntity<MessageResponse> getListSubCategory(@PathVariable String ID_Category) {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(categorydao.getListSubCategory(ID_Category));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @PostMapping("/AddCategory")
    public ResponseEntity<MessageResponse> AddCategory(@RequestBody Category category)
    {
        MessageResponse result = new MessageResponse();
        try {
//            Category ExistCategory=categorydao.findTopByOrderByIDProductDesc();
//            Integer id= (Integer.parseInt(ExistProduct.getID_Product())+1);
            Category CategoryInsert=new Category(category.getID_Category(),category.getName_Category(),category.getParent_Category());
            categorydao.save(CategoryInsert);
            result.setData(CategoryInsert);
            result.setMessage("Thêm danh mục thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    @PutMapping("/ChangeCategory")
    public ResponseEntity<MessageResponse> ChangeCategory(@RequestParam(name="id") String ID,
  @Valid @RequestBody Category category)
    {
        MessageResponse result = new MessageResponse();
        try {
            Category ExistCategory=categorydao.findByIDCategory(ID);
//            Integer id= (Integer.parseInt(ExistProduct.getID_Product())+1);
//            Product ProductInsert=new Product(id.toString(),product.getName_Product(),product.getImage(),product.getQuantity(),
//                    product.getDescribe(),product.getPrice(),product.getSale(),product.getWarranty_Period(),
//                    product.getID_Category(),product.getID_Brand(),product.getID_Season());
            ExistCategory.setName_Category(category.getName_Category());
            ExistCategory.setParent_Category(category.getParent_Category());
            
            categorydao.save(ExistCategory);
            result.setData(ExistCategory);
            result.setMessage("Thay đổi danh mục thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    @DeleteMapping("/Delete")
    public ResponseEntity<MessageResponse> DeleteCategory(@RequestParam(name="id") String ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            Category ExistCategory=categorydao.findByIDCategory(ID);
//         
            categorydao.delete(ExistCategory);
            result.setData(ExistCategory);
            result.setMessage("Xóa danh mục thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
}
