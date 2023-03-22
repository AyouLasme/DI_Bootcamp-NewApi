package com.api.taylor.modules;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Module {
    public static java.sql.Date createDate(String date) {
        try {
            java.util.Date dt = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(date);
            return new java.sql.Date(dt.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }


    public static String hashPassword(String passwordToHash){

        String generatedPassword = "";

        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(passwordToHash.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) { e.printStackTrace();  }

        return  generatedPassword ;
    }









}
