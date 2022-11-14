package com.test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 
 * @author ahmed
 * 15/11/2022
 *
 */
public class WlsHashing {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String password = hashPassword("welcome123", "SHA-1");
		System.out.println(password);
	}
	
	public static String hashPassword(String password, String algorithm){
        try {
        	MessageDigest md = MessageDigest.getInstance(algorithm);
        	md.update(password.getBytes());
        	byte[] encoded = Base64.getEncoder().encode(md.digest());
        	return "{" +algorithm + "}" + new String(encoded, StandardCharsets.UTF_8);
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
