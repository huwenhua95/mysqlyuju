package com.example.demo;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestngTests {
    @Test
    public void testCase1() {
       System.out.println("这是测试用例1 ");
    }
    @Test
    public void testCase2() {
        System.out.println("这是测试用例2");
    }
    @Before
    public void beforeMethod() {
        System.out.println(" BeforeMethod这是测试方法之前运行的 3");
    }

    @After
    public void afterMethod() {
        System.out.println("AfterMethod这是测试方法之后运行的 5");
    }

}

