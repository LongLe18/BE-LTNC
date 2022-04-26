/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;


import com.BTL.BTL_BE.Dao.SeasonDAO;
import com.BTL.BTL_BE.entity.Season;
import com.BTL.BTL_BE.payload.response.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
