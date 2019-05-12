package com.zhaolei.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SSM
 * 2019-05-10 10:12
 *
 * @author leonzhao
 **/

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(encodePassword(str));
    }
}
