package com.github.idouzi.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
@Component
public class APIHttpClient {

    private String contentType = "application/json";
    private String accept = "application/json";


    public String post(String apiURL, String parameters) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost method = new HttpPost(apiURL);
        method.addHeader("Content-type", contentType + "; charset=utf-8");
        method.setHeader("Accept", accept);
        method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));

        HttpResponse response = httpClient.execute(method);
        int statusCode = response.getStatusLine().getStatusCode();
        return EntityUtils.toString(response.getEntity());

    }

    public String postForm(String apiURL, List parameters) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost method = new HttpPost(apiURL);
        String responseContent = null;
        try {

            method.addHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
            method.setHeader("Accept", accept);
            method.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));


            HttpResponse response = httpClient.execute(method);
            int statusCode = response.getStatusLine().getStatusCode();
            responseContent = EntityUtils.toString(response.getEntity());
            return responseContent;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
            return responseContent;
        }

    }
    public String postForm1(String apiURL, List parameters) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost method = new HttpPost(apiURL);
        String responseContent = null;
        try {

            method.addHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
            method.setHeader("Accept", accept);
            method.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));


            HttpResponse response = httpClient.execute(method);
            int statusCode = response.getStatusLine().getStatusCode();
            responseContent = EntityUtils.toString(response.getEntity());
            return responseContent;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
            return responseContent;
        }

    }


    public String get(String apiURL) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet method = new HttpGet(apiURL);
        method.addHeader("Content-type", contentType + "; charset=utf-8");
        method.setHeader("Accept", accept);

        HttpResponse response = httpClient.execute(method);

        int statusCode = response.getStatusLine().getStatusCode();

        return EntityUtils.toString(response.getEntity());

    }

    public APIHttpClient setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public APIHttpClient setAccept(String accept) {
        this.accept = accept;
        return this;
    }
}