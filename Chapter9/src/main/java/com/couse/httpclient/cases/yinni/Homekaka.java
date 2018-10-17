package com.couse.httpclient.cases.yinni;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Homekaka {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
   // private String Token;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url=bundle.getString("yn.url");

    }
    @Test
    public void testWithCookies() throws IOException {
        String uri = bundle.getString("ynhome.uri");
        String testUrl = this.url+uri;

        DefaultHttpClient client = new DefaultHttpClient();

        HttpPost post = new HttpPost(testUrl);

//        Login l =new Login();
//        String Token =  l.testGetCookie();

 //       post.setHeader("Token",Token);

        String result;

        HttpResponse response =client.execute(post);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("result:"+result);

        JSONObject resultJson = new JSONObject(result);
        System.out.println("resultJson："+resultJson);

        Boolean success = (Boolean) resultJson.get("success");

        Assert.assertEquals(success,Boolean.TRUE);


    }
    }

