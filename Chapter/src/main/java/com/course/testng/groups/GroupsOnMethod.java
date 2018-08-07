package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups ="server")
    public void test1(){
        System.out.println("server method111");
    }

    @Test(groups ="server")
    public void test2(){
        System.out.println("server method222");
    }

    @Test(groups ="client")
    public void test3(){
        System.out.println("client method333");
    }

    @Test(groups ="client")
    public void test4(){
        System.out.println("client method444");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("server groups before!!!");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("server groups after!!!");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("client groups before!!!");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("client groups after!!!");
    }

}
