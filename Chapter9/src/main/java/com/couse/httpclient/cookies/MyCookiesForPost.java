package com.couse.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
    public void testPost() throws IOException {
        String uri = bundle.getString("test.postWithCookie.uri");
        String testUrl = this.url+uri;

        //声明一个Client对象 用来进行方法执行
        DefaultHttpClient client = new DefaultHttpClient();

        //声明一个方法，post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数

        JSONObject param = new JSONObject();
        param.put("name","Ashley");
        param.put("age","18");

        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //声明对象进行响应结果存储
        String result;

        //设置cookie信息
        client.setCookieStore(this.cookieStore);

        //执行post方法
        HttpResponse response =client.execute(post);

        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("result:"+result);

        //处理结果，判断返回结果是否符合预期
        //将返回的响应结果字符串转化为json对象
        JSONObject resultJson = new JSONObject(result);
//        System.out.println("resultJson："+resultJson);

        //获取结果值
        String success = (String) resultJson.get("Ashley");
        String status = (String) resultJson.get("status");

        //具体判断返回结果的值
        Assert.assertEquals(success,"success");
        Assert.assertEquals(status,"1");

    }


}
