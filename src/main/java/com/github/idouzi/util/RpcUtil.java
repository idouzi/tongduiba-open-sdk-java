package com.github.idouzi.util;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
public class RpcUtil {
    public Map<String, Object> sendApiGet(String url) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            String resp = new APIHttpClient().get(url);
            returnMap = JSON.parseObject(resp);
            return returnMap;
        } catch (IOException e) {
            e.printStackTrace();
            return returnMap;
        }
    }
}
