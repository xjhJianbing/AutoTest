package com.course.testng;


import org.testng.annotations.*;

public class BasicaAnnotation {

    //最基本的注解 用来吧方法标记为测试的一部分
    @Test
    public void testCase(){
        System.out.println("这是第一个测试case");
    }
    @Test
    public void testCase2(){
        System.out.println("这是第一个测试case2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod 测试方法前");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod 测试方法之后");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass类之前");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass类之后");
    }
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforesuit");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("aftersuit");
    }
}
