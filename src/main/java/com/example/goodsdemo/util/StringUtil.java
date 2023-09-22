package com.example.goodsdemo.util;

public class StringUtil {

	public static boolean isEmpty(String s) {
		return s == null || s.isBlank();
	}

	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
}
