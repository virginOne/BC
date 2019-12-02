package com.zjj.bc.utils.crypto;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *ClassName:RSACipher
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月29日
 *@Version 1.0
 */
public class RSACipherUtil {
	private final static String CRYPTO_METHOD = "RSA";
    private final static int CRYPTO_BITS = 2048;

    private static KeyFactory KEY_FACTORY;
    private static Signature SIGNATURE;
    
    static {
    	try {
			KEY_FACTORY=KeyFactory.getInstance(CRYPTO_METHOD);
			SIGNATURE=Signature.getInstance(CRYPTO_METHOD);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    }
    
    public static KeyPair getKeyPair() {
        KeyPair kp = null;
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance(CRYPTO_METHOD);
            kpg.initialize(CRYPTO_BITS);
            kp = kpg.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kp;
    }
    
    public static String getPublicKeyStr(PublicKey publicKey) {
    	return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }
    public static String getPrivateKeyStr(PrivateKey privateKey) {
    	return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public static PublicKey getPublicKey(String publicKeyStr) throws InvalidKeySpecException {
    	PublicKey publicKey=null;
    	byte[] keyBytes=Base64.getDecoder().decode(publicKeyStr);
		publicKey=KEY_FACTORY.generatePublic(new X509EncodedKeySpec(keyBytes));
    	return publicKey;
    }
    
    public static PrivateKey getPrivateKey(String privateKeyStr) throws InvalidKeySpecException {
    	PrivateKey privateKey=null;
    	byte[] keyBytes=Base64.getDecoder().decode(privateKeyStr);
		privateKey=KEY_FACTORY.generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
    	return privateKey;
    }
    
    public static byte[] sign(byte[] data, PrivateKey privateKey) throws InvalidKeyException, SignatureException {
    	SIGNATURE.initSign(privateKey);
    	SIGNATURE.update(data);
    	return SIGNATURE.sign();
    }
    
    public static boolean verify(byte[] data,byte[] sign, PublicKey publicKey) throws SignatureException, InvalidKeyException {
    	SIGNATURE.initVerify(publicKey);
    	SIGNATURE.update(data);
    	return SIGNATURE.verify(sign);
    }
    
    public static byte[] encrypt(byte[] data, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(CRYPTO_METHOD);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data,PublicKey publicKey) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(CRYPTO_METHOD);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }
}
