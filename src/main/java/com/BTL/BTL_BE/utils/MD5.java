package com.BTL.BTL_BE.utils;

import java.security.MessageDigest;
import org.springframework.stereotype.Component;

@Component
public class MD5 {
    public String md5(String MD5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(MD5.getBytes());
            byte[] b = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte x : b) {
                    sb.append(Integer.toHexString(x & 0xff).toString());
            }
            return sb.toString();
        } catch (Exception e) {
            return "123";
        }

    }
}
