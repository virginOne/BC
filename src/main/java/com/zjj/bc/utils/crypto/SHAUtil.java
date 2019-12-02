package com.zjj.bc.utils.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *ClassName:SHAUtil
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月30日
 *@Version 1.0
 */
public class SHAUtil {
	private final static String CRYPTO_METHOD="SHA-256";
	private static MessageDigest messageDigest;
	static {
		try {
			messageDigest=MessageDigest.getInstance(CRYPTO_METHOD);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] SHA256(byte[] data) {
		return messageDigest.digest(data);
	}
}
