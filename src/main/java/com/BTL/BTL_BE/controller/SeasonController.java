/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;


import com.BTL.BTL_BE.Dao.SeasonDAO;
import com.BTL.BTL_BE.entity.Category;
import com.BTL.BTL_BE.entity.Season;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nguye
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Season")
public class SeasonController {
    @Autowired
    SeasonDAO seasondao;
    @GetMapping("/getSeason")
    public ResponseEntity<MessageResponse> GetAllSeason()
    {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(seasondao.findAll());
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    @GetMapping("/getNameSeason")
    public ResponseEntity<MessageResponse> GetNameSeason()
    {
        MessageResponse result = new MessageResponse();
        List<Season> arr=new ArrayList<Season>();
        List<String> arr2=new ArrayList<String>();
        try {
            arr=seasondao.findAll();
            for(int i=0;i<arr.size();i++)
            {
                arr2.add(arr.get(i).getName_Season());
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
       
    @GetMapping("/getSeason/{ID_Season}")
    public ResponseEntity<MessageResponse> getListSubCategory(@PathVariable int ID_Season) {
        MessageResponse result = new MessageResponse();
        try {
            result.setData(seasondao.findByIDSeason(ID_Season));
            result.setMessage("Thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @PostMapping("/addSeason")
    public ResponseEntity<MessageResponse> AddCategory(@RequestBody Season season)
    {
        MessageResponse result = new MessageResponse();
        try {
            Season SeasonInsert = new Season(season.getID_Season(),season.getName_Season(),season.getDateStart(), season.getDateEnd());
            seasondao.save(SeasonInsert);
            result.setData(SeasonInsert);
            result.setMessage("Thêm mùa sự kiện thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    
    @DeleteMapping("/Delete")
    public ResponseEntity<MessageResponse> DeleteCategory(@RequestParam(name="id") int ID)
    {
        MessageResponse result = new MessageResponse();
        try {
            Season ExistSeason = seasondao.findByIDSeason(ID);        
            seasondao.delete(ExistSeason);
            result.setData(ExistSeason);
            result.setMessage("Xóa mùa sự kiện thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
    
    @PutMapping("/ChangeSeason")
    public ResponseEntity<MessageResponse> ChangeCategory(@RequestParam(name="id") int ID,
            @Valid @RequestBody Season season)
    {
        MessageResponse result = new MessageResponse();
        try {
            Season ExistSeason = seasondao.findByIDSeason(ID);
            ExistSeason.setName_Season(season.getName_Season());
            ExistSeason.setDateStart(season.getDateStart());            
            ExistSeason.setDateEnd(season.getDateEnd());
      
            seasondao.save(ExistSeason);
            result.setData(ExistSeason);
            result.setMessage("Thay đổi sự kiện thành công");
            return new ResponseEntity<MessageResponse>(result, HttpStatus.OK);
        } catch(Exception e) {
            result.setStatus(MessageResponse.Status.FAILED);
            result.setMessage("Lỗi " + e);
                
            return new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST);
        }    
    }  
}
