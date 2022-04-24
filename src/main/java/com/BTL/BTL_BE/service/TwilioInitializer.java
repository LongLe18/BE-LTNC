/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.service;

/**
 *
 * @author ACER
 */
import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.BTL.BTL_BE.entity.Twillo;

@Configuration
public class TwilioInitializer {
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);
    private final Twillo twilioConfiguration;
    @Autowired
    public TwilioInitializer(Twillo twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
            twilioConfiguration.getAccountSid(),
            twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialized ... with account sid {} ", twilioConfiguration.getAccountSid());
    }
}
