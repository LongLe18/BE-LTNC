/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.service;

/**
 *
 * @author ACER
 */
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BTL.BTL_BE.Dao.SmsSenderDAO;
import com.BTL.BTL_BE.entity.Twillo;
import com.BTL.BTL_BE.payload.request.SmsRequest;
import com.BTL.BTL_BE.entity.Verification;

@Service("twilio")
public class TwilioSmsSender implements SmsSenderDAO{
    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);
    private final Twillo twilioConfiguration;
    @Autowired
    public TwilioSmsSender(Twillo twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }
    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            int min = 100000;  
            int max = 999999; 
            int number = (int)(Math.random()*(max-min+1)+min);
        
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = "Your OTP - " + number +  " please verify this OTP in your Application";
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            Verification.setOtp(number);
            LOGGER.info("Send sms {}", smsRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number"
            );
        }
    }
    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: Implement phone number validator
        return true;
    }
}
