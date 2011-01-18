package cn.edu.sjtu.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EncryptionUtils {

	private static final Log log = LogFactory.getLog(EncryptionUtils.class);
	
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			
			messageDigest.reset();
			
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			log.error("NoSuchAlgorithmException caught!", e);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}
		
		byte[] byteArray = messageDigest.digest();
		
		StringBuffer md5StrBuff = new StringBuffer();
		
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		
		return md5StrBuff.toString();
	}
	
	public static String encryptSHA256Base16(String plaintext) {
		String digest = null;
		if (plaintext != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(plaintext.getBytes("UTF-8"));
				byte[] raw = md.digest();
				digest = Base16.toString(raw);
			} catch (NoSuchAlgorithmException e) {
				log.warn("Error encrypting SHA 256", e);
			} catch (UnsupportedEncodingException e) {
				log.warn("Error encrypting SHA 256", e);
			}
		}
		return digest;
	}
	
	public static void main(String[] args) {
		log.debug(encryptSHA256Base16("111111"));
		log.debug(EncryptionUtils.getMD5Str("123456"));
	}

}