package com.cloud.common.encrypt;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 加密算法工具类
 *
 * @author Jon_China
 * @create 2018/1/18
 */
public final class EncryptUtil {

    private static final String EMPTY_STRING = "";

    private static final String CHARSET = "UTF-8";

    private EncryptUtil(){}

    /**
     * 使用base64对字符串加密
     * @param origin
     * @return
     */
    public static String base64Encode(String origin){
        try {
            byte[] originByte = origin.getBytes(CHARSET);
            byte[] encodeByte = Base64.getEncoder().encode(originByte);
            return new String(encodeByte,CHARSET);
        }catch (UnsupportedEncodingException e){
            return EMPTY_STRING;
        }
    }

    /**
     * 使用base64对字符串进行解密
     * @param origin
     * @return
     */
    public static String base64Decode(String origin){
        try {
            byte[] originByte = origin.getBytes(CHARSET);
            byte[] decodeByte = Base64.getDecoder().decode(originByte);
            return new String(decodeByte,CHARSET);
        }catch (UnsupportedEncodingException e){
            return EMPTY_STRING;
        }
    }

    /**
     * 使用sha512加密
     * @param origin
     * @return
     */
    public static String encryptSha512(String origin){
        String shaEncode = DigestUtils.sha512Hex(origin);
        //使用base64加密
        return base64Encode(shaEncode);
    }

    /**
     * 使用sha256加密
     * @param origin
     * @return
     */
    public static String encryptSha216(String origin){
        String shaEncode = DigestUtils.sha256Hex(origin);
        //使用base64加密
        return base64Encode(shaEncode);
    }
}
