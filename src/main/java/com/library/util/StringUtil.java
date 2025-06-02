package com.library.util;

/**
 * 字符串工具类
 */
public class StringUtil {
    
    /**
     * 判断字符串是否为空
     *
     * @param str 需要判断的字符串
     * @return 如果字符串为null或空字符串返回true，否则返回false
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * 判断字符串是否非空
     *
     * @param str 需要判断的字符串
     * @return 如果字符串不为null且不是空字符串返回true，否则返回false
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
} 