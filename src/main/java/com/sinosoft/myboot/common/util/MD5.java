package com.sinosoft.myboot.common.util;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * <B>系统名称：统一清算结算系统</B><BR>
 * <B>模块名称：MD5</B><BR>
 * <B>中文类名：支付宝MD5签名处理核心文件</B><BR>
 * <B>概要说明：支付宝MD5签名处理核心文件</B><BR>
 * 
 * @author 中科软科技 haoxl
 * @since 2016年5月24日
 */
public class MD5 {

    /**
     * 
     * <B>方法名称：sign</B><BR>
     * <B>概要说明：签名字符串</B><BR>
     * 
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String input_charset) {
        text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }

    /**
     * 
     * <B>方法名称：verify</B><BR>
     * <B>概要说明：签名字符串</B><BR>
     * 
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String input_charset) {
        text = text + key;
        String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
        if (mysign.equals(sign)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

}