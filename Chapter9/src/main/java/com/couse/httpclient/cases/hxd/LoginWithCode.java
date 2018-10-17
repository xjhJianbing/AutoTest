package com.couse.httpclient.cases.hxd;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginWithCode {
    private String url;
    private ResourceBundle bundle;
   // private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url=bundle.getString("hxd.url");
    }

    @Test
    public void testPost() throws IOException {
        String uri = bundle.getString("loginWithCode.uri");
        String testUrl= this.url+uri;

        //声明一个Client对象 用来进行方法执行
        DefaultHttpClient client = new DefaultHttpClient();

        //声明一个方法，post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数

        JSONObject param = new JSONObject();
        param.put("phone","17767062600");
        param.put("cv","ios1.0.0/hualu");
        param.put("ov","ios11.0.3");
        param.put("app","123");
        param.put("code","0110");

        //设置请求头信息 设置header
       // post.setHeader("Content-Type","application/x-www-form-urlencoded");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //声明对象进行响应结果存储
        String result;

        //设置cookie信息
       // client.setCookieStore(this.cookieStore);

        //执行post方法
        HttpResponse response =client.execute(post);

        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        //System.out.println("result:"+result);

        //处理结果，判断返回结果是否符合预期
        //将返回的响应结果字符串转化为json对象
        JSONObject resultJson = new JSONObject(result);
       //System.out.println("resultJson："+resultJson);

        //获取结果值
         Boolean res = (Boolean) resultJson.get("success");

        //具体判断返回结果的值
        Assert.assertEquals(res,Boolean.TRUE);

    }


}
