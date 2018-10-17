package com.couse.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookieForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url=bundle.getString("test.url");
    }

    @Test
    public void testGetCookie() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testUrl= this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookie信息
        this.cookieStore = client.getCookieStore();
        List<Cookie> cookieList = cookieStore.getCookies();

        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:"+name+" ;value:"+value);
        }

    }
    @Test(dependsOnMethods = {"testGetCookie"})
    public void testWithCookies() throws IOException {
        String result;
        String uri = bundle.getString("test.getWithCookie.uri");
        String testUrl= this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookie信息
        client.setCookieStore((CookieStore) this.cookieStore);
        HttpResponse response = client.execute(get);

        //获取相应状态码
        int status = response.getStatusLine().getStatusCode();
        System.out.println("status:"+status);

        if(status == 200){
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
}
