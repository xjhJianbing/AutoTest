package com.couse.httpclient.cases.yinni;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Daikuan {
    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url=bundle.getString("yn.url");
    }

    @Test
    public void testGet() throws IOException {
        String result;
        String uri = bundle.getString("yndaikuan.uri");
        String testUrl= this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(get);

        result  = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONObject resultJson = new JSONObject(result);

        Boolean success = resultJson.getBoolean("success");
        Assert.assertEquals(success,Boolean.TRUE);

     //   JSONObject ret =  resultJson.getJSONObject("ret");
  //      JSONArray list = ret.getJSONArray("option_list");

//        for(int i=0;i<list.length();i++){
////           System.out.println(list.getJSONObject(i));
//            try {
//                JSONObject j = list.getJSONObject(i);
//                System.out.println(j);
//                Double rate = j.getDouble("rate");
//                Assert.assertEquals(rate,0.01);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

  //      }

    }

}
