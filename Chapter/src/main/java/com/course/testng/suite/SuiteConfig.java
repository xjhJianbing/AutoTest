package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforesuit开始啦");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("aftersuit 开始啦");
    }
}
