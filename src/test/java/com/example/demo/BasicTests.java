package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeMethod;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTests {
    @Test
    public void testCase1() {
        System.out.println("Test这是测试用例1");
    }
    @Test
    public void testCase2() {
        System.out.println("Test这是测试用例1");
    }

    @Before
    public void beforeMethod() {
        System.out.println(" BeforeMethod这是测试方法之前运行的");
    }
    @After
    public void beforeMethod1() {
        System.out.println(" BeforeMethod这是测试方法之前运行的111");
    }
}
