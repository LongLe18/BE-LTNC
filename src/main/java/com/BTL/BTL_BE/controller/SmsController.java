/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.controller;

/**
 *
 * @author ACER
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BTL.BTL_BE.service.SmsService;
import com.BTL.BTL_BE.payload.request.SmsRequest;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.BTL.BTL_BE.entity.Verification;
import com.BTL.BTL_BE.payload.request.VerifyRequest;
import com.BTL.BTL_BE.payload.response.MessageResponse;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/sms")
public class SmsController {
    
    private final SmsService smsService;
    
    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }
       
    @PostMapping("/getCode")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest);
    }
    
    @PostMapping("/verify")
    public ResponseEntity<?> ValidateToken(@Valid @RequestBody VerifyRequest verifyRequest){
		
        int sentotp = verifyRequest.getCode();
        if(sentotp == Verification.getOtp()) {
            MessageResponse result = new MessageResponse();
            result.setMessage("Thành công: Xác thực thành công!");
            return ResponseEntity.ok()
                .body(new ResponseEntity<MessageResponse>(result, HttpStatus.ACCEPTED));
        }
        MessageResponse result = new MessageResponse();
        result.setStatus(MessageResponse.Status.FAILED);
        result.setMessage("Lỗi: Mã xác thực không đúng hoặc hết hạn!");
        return ResponseEntity.badRequest()
            .body(new ResponseEntity<MessageResponse>(result, HttpStatus.BAD_REQUEST));
    } 
}
