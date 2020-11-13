package com.github.idouzi.sdk;


import com.github.idouzi.util.RpcUtil;
import com.github.idouzi.util.UuidUtils;
import com.github.idouzi.util.sign.SignUtil;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class TdbClient {

    private String appKey;
    private String appSecret;
    private String domain = "https://points-mall.henshihui.com";

    public TdbClient(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    /**
     * 免登录地址接口
     *
     * @param method 方法路径
     * @param params {
     *               "unionId":"",
     *               "redirect":"",
     *               "openId":"",
     *               "source":""
     *               }
     *               unionId  该字段如果为空字符串，则标记为游客用户
     *               redirect 需要进行urlencode编码，可以直达积分商城内的任意页面，如果不带redirect参数，默认跳转到积分商城首页
     *               openId   小程序接入必传
     *               source   ['app', 'wx', 'mp'] = [客户端, 公众号, 小程序]，默认app
     * @return 免登录地址
     */
    public String getUrl(String method, Map<String, Object> params) throws Exception {
        StringBuilder url = new StringBuilder(domain + method + "?");
        //获取公共参数
        params.putAll(getPublicParams());
        String sign = new SignUtil().createSign(params, appSecret);
        params.put("sign", sign);
        Set<String> keySet = params.keySet();
        //拼接字符串
        for (String key : keySet) {
            url.append(key).append("=").append(params.get(key)).append("&");
        }
        String string = url.toString();
        if (string.endsWith("&")) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    /**
     * 获取公共参数
     *
     * @return
     */
    public HashMap<String, Object> getPublicParams() {
        HashMap<String, Object> params = new HashMap();
        String nonceStr = UuidUtils.getuuid(25);
        String timestamp = "" + (System.currentTimeMillis() / 1000);
        params.put("appKey", appKey);
        params.put("timestamp", timestamp);
        params.put("nonceStr", nonceStr);
        params.put("s_ver", "1");
        return params;
    }


    /**
     * 方法调用
     *
     * @param params {
     *               "unionId":""
     *               }
     * @return
     * @throws Exception
     */
    public Map<String, Object> get(String method, Map<String, Object> params) throws Exception {
        StringBuilder url = new StringBuilder(domain + method + "?");
        Map<String, Object> resultMap = new HashMap<>(4);
        //获取公共参数
        params.putAll(getPublicParams());
        String sign = new SignUtil().createSign(params, appSecret);
        params.put("sign", sign);
        Set<String> keySet = params.keySet();
        //拼接字符串
        for (String key : keySet) {
            url.append(key).append("=").append(params.get(key)).append("&");
        }
        String string = url.toString();
        if (string.endsWith("&")) {
            string = string.substring(0, string.length() - 1);
        }
        return new RpcUtil().sendApiGet(string);
    }




}
