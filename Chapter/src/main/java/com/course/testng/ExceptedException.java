package com.course.testng;

import org.testng.annotations.Test;

public class ExceptedException {
    /**
     * 当我们期望某一个结果为异常的时候
     * 比如传入某些不合法的参数 程序跑出了异常
     * 也就是说我们的预期结果就是这个异常
     */
    //这是一个测试结果会失败的异常测试
//    @Test(expectedExceptions = RuntimeException.class)
//    public void runTimeExceptionFailed(){
//        System.out.println("这是一个会失败的异常测试");
//    }
    //这是一个测试结果会成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是一个会成功的异常测试");
        throw new RuntimeException();
    }






}
