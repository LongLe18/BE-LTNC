/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

/**
 *
 * @author ACER
 */
import com.BTL.BTL_BE.payload.request.SmsRequest;

public interface SmsSenderDAO {
    void sendSms(SmsRequest smsRequest);
    // or maybe void sendSms(String phoneNumber, String message);
}
