import com.github.idouzi.util.sign.SignUtil;
import com.google.gson.Gson;
import com.github.idouzi.sdk.TdbClient;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shirley
 * @Description:
 * @Date: Created in 15:27 2020/9/17
 */
public class testClient {


    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();

/*
        TdbClient tdbClient = new TdbClient("5e84462851af1","dee11a8e7c9a63eef48a6bf9179fa937");
        Map params = new HashMap();
        params.put("redirect", "");
        params.put("unionId", "10001");
        params.put("openId", "");
        params.put("source", "app");
        String autoLogin = tdbClient.getUrl("/v1/user/login/auto-login", params);
        System.out.println(autoLogin);*/

      /*  Map urlParams = new HashMap();
        urlParams.put("unionId", "10001");
        Map map = tdbClient.get("/sdk/api/query-user-points-amount", urlParams);
        System.out.println(gson.toJson(map));
        Map params = new HashMap();
        params.put("redirect", "");
        params.put("unionId", "10001");
        params.put("openId", "");
        params.put("source", "app");
        String aa = new SignUtil().createSign(params, "aa");
        System.out.println(aa);*/

        TdbClient tdbClient = new TdbClient("", "");
        Map params = new HashMap();
        params.put("redirect", "");
        params.put("unionId", "798");
        params.put("openId", "");
        params.put("source", "app");
        String autoLogin = tdbClient.getUrl("/v1/user/login/auto-login", params);
        System.out.println(autoLogin);

        Map urlParams = new HashMap();
        urlParams.put("unionId", "798");
        Map map = tdbClient.get("/sdk/api/change-member-level", urlParams);
        System.out.println(gson.toJson(map));
    }

}
