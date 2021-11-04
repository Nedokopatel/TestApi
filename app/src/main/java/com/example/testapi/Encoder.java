package com.example.testapi;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.security.auth.login.LoginException;

public class Encoder {
    private static String result;
    public static String Encryption(String password) throws LoginException, NoSuchAlgorithmException{
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        byte[] bytes = sha1.digest(password.getBytes());
        StringBuilder builder = new StringBuilder();
        for(byte b:bytes){
            builder.append(String.format("%02x",b));
        }
        result = builder.toString();
        return result;
    }
}
