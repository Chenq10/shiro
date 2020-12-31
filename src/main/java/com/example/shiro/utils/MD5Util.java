package com.example.shiro.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MD5加密工具类 同时使用加盐处理获得新48位密码 generatePwdBySalt(String password, String
 * key)/generatePwdBySalt(String password)
 * 
 * @author CQYL
 *
 */
public class MD5Util {

	private static Logger logger = LoggerFactory.getLogger(MD5Util.class);

	/*
	 * 使用UUID随机的加盐码，长度必须为16位
	 */
	private final static String SALT = "7b4aaf76bda5449d";

	/**
	 * MD5加密方法
	 * 
	 * @param text 明文
	 * @param key  密钥
	 * @return 密文
	 * @throws Exception
	 */
	public static String md5(String text, String key) throws Exception {
		logger.info("字符串加密中...");
		// 加密后的字符串
		String encodeStr = DigestUtils.md5Hex(text + key);
		logger.info("加密字符串为" + encodeStr);
		return encodeStr;
	}

	/**
	 * MD5验证方法
	 * 
	 * @param text 待验证明文
	 * @param key  密钥
	 * @param md5  密文
	 * @return true/false
	 * @throws Exception
	 */
	public static boolean verify(String text, String key, String md5) throws Exception {
		boolean flag = false;
		String md5Text = md5(text, key);
		// md5加密码不区分大小写
		if (md5.equalsIgnoreCase(md5Text)) {
			flag = true;
		}
		return flag;
	}

	
	/**
	 * 通过加盐，将32位的MD5密码和16位的加盐码，组合成一个新的48位密码
	 * 
	 * @param password 用户密码
	 * @param key      密钥
	 * @return 加盐新密码
	 * @throws Exception
	 */
	public static String generatePwdBySalt(String password, String key) throws Exception {
		// 根据传入密钥获取加盐码
		String salt = getSalt(key);
		// 使用MD5获取加盐后的密码(32位)
		password = md5(password, salt);
		char[] passChars = password.toCharArray();
		char[] saltChars = salt.toCharArray();
		char[] newPassChars = new char[48];
		// 将MD5密码每个字符使用加盐码隔开，合成新密码
		for (int i = 0; i < 48; i += 3) {
			newPassChars[i] = passChars[i / 3 * 2];
			newPassChars[i + 1] = saltChars[i / 3];
			newPassChars[i + 2] = passChars[i / 3 * 2 + 1];
		}
		return new String(newPassChars).toUpperCase();
	}

	/**
	 * 通过加盐，将32位的MD5密码和16位的加盐码，组合成一个新的48位密码
	 * 
	 * @param password 用户密码
	 * @return 加盐新密码
	 * @throws Exception
	 */
	public static String generatePwdBySalt(String password) throws Exception {
		return generatePwdBySalt(password, null);
	}

	/**
	 * 	验证加盐码
	 * @param password	用户密码
	 * @param md5		原始MD5字符串
	 * @return			true/false
	 * @throws Exception
	 */
	public static boolean verifySaltPwd(String password, String md5) throws Exception {
		// 获取传入的MD5加密字符串
		char[] md5Chars = md5.toLowerCase().toCharArray();
		char[] baseMd5Chars = new char[32];
		char[] saltChars = new char[16];
		for (int i = 0; i < md5Chars.length; i += 3) {
			// 获取不加盐MD5码
			baseMd5Chars[i / 3 * 2] = md5Chars[i];
			baseMd5Chars[i / 3 * 2 + 1] = md5Chars[i + 2];
			// 获取加盐码
			saltChars[i / 3] = md5Chars[i + 1];
		}
		String salt = new String(saltChars);
		boolean flag = md5(password, salt).equals(new String(baseMd5Chars));
		return flag;
	}

	/**
	 * 获取加盐码
	 * 
	 * @param key 密钥
	 * @return 加盐码
	 */
	private static String getSalt(String key) {
		String salt = null;
		if (key == null || " ".equals(key) || key.length() == 0) {
			// 传入加盐码为空，直接返回默认的加盐码
			salt = MD5Util.SALT;
		} else if (key.length() <= 16) {
			// 传入加盐码不为空，采用和默认加盐码混合截取的方式获得加盐码
			salt = getStrLen8(key) + MD5Util.SALT.substring(7, 15);
		} else {
			salt = key.substring(4, 12) + MD5Util.SALT.substring(2, 10);
		}
		return salt;
	}

	/**
	 * 截取字符串长读的8位，长度不够使用默认加盐码拼凑
	 * 
	 * @param str 传入字符串
	 * @return 截取后的字符串
	 */
	private static String getStrLen8(String str) {
		String backStr = null;
		if (str.length() == 8) {
			backStr = str;
		}
		if (str.length() > 8) {
			backStr = str.substring(1, 9);
		} else {
			backStr = getStrLen8(str + MD5Util.SALT);
		}
		return backStr;
	}

	public static void main(String args[]) {
		try {
			String password = md5("123456", "");
			System.out.println(verify("123456","","e10adc3949ba59abbe56e057f20f883e"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
