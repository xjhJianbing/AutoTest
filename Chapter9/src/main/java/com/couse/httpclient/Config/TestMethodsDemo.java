package com.couse.httpclient.Config;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {

    @Test
    public void tes11(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("qqq","qqq");
    }

    @Test
    public void logDemo(){
        Reporter.log("这是我自己的log");
        throw new RuntimeException("这是我自己的运行时异常");
    }


}
