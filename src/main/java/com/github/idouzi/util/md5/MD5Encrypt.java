package com.github.idouzi.util.md5;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
@Component
public class MD5Encrypt {
    public String md5(String inStr) {
        try {
            return DigestUtils.md5Hex(inStr.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误");
        }
    }
}
