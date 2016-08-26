package com.lasun.association.platform.util.security;

import com.lasun.association.platform.util.constant.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 消息签名加密，默认提供 MD5 和 SHA256
 */
public class MessageDigestSecurity {
    public static MessageDigestSecurity MD5 = new MessageDigestSecurity("MD5");
    public static MessageDigestSecurity SHA256 = new MessageDigestSecurity("SHA-256");
    private MessageDigest messageDigest;

    private MessageDigestSecurity(String securityType) {
        try {
            this.messageDigest = MessageDigest.getInstance(securityType);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String content) {
        return encrypt(content.getBytes());
    }

    public String encrypt(InputStream content) {
        try {
            DigestInputStream din = new DigestInputStream(content, messageDigest);
            int buferSize = Constant.FILE_BUFFER_SIZE < content.available() ? Constant.FILE_BUFFER_SIZE : content.available();
            byte[] buffer = new byte[buferSize];
            int tmp = 0;
            while (din.read(buffer, tmp * buferSize, buferSize) > -1) ;
            din.close();
            byte[] digest = messageDigest.digest();
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                result.append(Integer.toHexString(digest[i] & 0xFF));
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String encrypt(byte[] content) {
        StringBuffer result = new StringBuffer();
        byte[] securityByte = messageDigest.digest(content);
        for (int i = 0; i < securityByte.length; i++) {
            byte item = securityByte[i];
            result.append(Integer.toHexString(item & 0xFF));
        }
        return result.toString();
    }

    public boolean validate(String content, String security) {
        return security.equals(encrypt(content.getBytes()));
    }

    public boolean validate(byte[] content, String security) {
        return security.equals(encrypt(content));
    }

    public boolean validate(InputStream content, String security) {
        return security.equals(encrypt(content));
    }
}
