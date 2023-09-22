package com.example.goodsdemo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtils {

	/**
	 * 用來將密碼加密不可直接將明碼直接存入DB
	 * 使用 BCryptPasswordEncoder 需先引入依賴 spring-boot-starter-security
	 * https://blog.csdn.net/u012888704/article/details/107406374
	 * https://blog.csdn.net/weixin_44634197/article/details/108404580#:~:text=%E5%AF%86%E7%A0%81%E5%8A%A0%E5%AF%86%E4%BD%BF%E7%94%A8%E6%96%B9%E6%B3%95%3A%201%20%E4%BD%BF%E7%94%A8DigestUtils%E8%BF%9B%E8%A1%8CMD5%E7%9B%90%E5%80%BC%E5%8A%A0%E5%AF%86%E6%97%B6%2C%20%E9%9C%80%E8%A6%81%E5%9C%A8%E6%95%B0%E6%8D%AE%E5%BA%93%E4%B8%AD%E5%90%8C%E6%97%B6%E7%BB%B4%E6%8A%A4%E4%B8%80%E4%B8%AAsalt%E5%AD%97%E6%AE%B5%3B%202,%E5%BD%93%E8%BF%9B%E8%A1%8C%E5%AF%86%E7%A0%81%E8%AE%A4%E8%AF%81%E6%97%B6%2C%E5%B0%86%E6%95%B0%E6%8D%AE%E5%BA%93%E4%B8%AD%E7%9A%84salt%E5%AD%97%E6%AE%B5%E4%B8%8E%E7%94%A8%E6%88%B7%E6%8F%90%E4%BA%A4%E7%9A%84%E5%AF%86%E7%A0%81%20%E5%86%8D%E6%AC%A1%E8%BF%9B%E8%A1%8CMD5%E7%9B%90%E5%80%BC%E5%8A%A0%E5%AF%86%20%E5%BE%97%E5%88%B0%E7%BB%93%E6%9E%9CA%3B%203%20%E6%AF%94%E8%BE%83%E7%BB%93%E6%9E%9CA%E6%98%AF%E5%90%A6%E4%B8%8E%E6%95%B0%E6%8D%AE%E5%BA%93%E4%B8%AD%E5%AD%98%E5%82%A8%E7%9A%84password%E5%AD%97%E6%AE%B5%E7%9B%B8%E5%90%8C.
	 * @param password 需要加密的是使用者
	 */
	public static String encodePassword(String password) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

	public static Boolean matchesPassword(String rawPassword, String encodedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
