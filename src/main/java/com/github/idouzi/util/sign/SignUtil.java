package com.github.idouzi.util.sign;


import com.github.idouzi.util.md5.MD5Encrypt;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
@Component
public class SignUtil {
    /**
     * 签名算法
     *
     * @param params    待签名数据
     * @param appSecret
     * @return
     * @throws Exception
     */
    public String createSign(Map<String, Object> params, String appSecret) throws Exception {
        //检查参数
        if (!params.containsKey("timestamp") || !params.containsKey("nonceStr") || !params.containsKey("appKey")) {
            throw new Exception("缺少必备参数!");
        }
        //传送的sign参数不参与签名，将生成的签名与该sign值作校验
        if (params.containsKey("sign")) {
            params.remove("sign");
        }
        StringBuilder valueSb = new StringBuilder();
        Map<String, Object> sortParams = new TreeMap<String, Object>(params);
        //参数名ASCII码从小到大排序 ( 字典序 )
        Set<Map.Entry<String, Object>> entrySet = sortParams.entrySet();
        //拼接字符串
        for (Map.Entry<String, Object> entry : entrySet) {
            valueSb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        valueSb.append("appSecret=" + appSecret);
        return new MD5Encrypt().md5(valueSb.toString());
    }
}
