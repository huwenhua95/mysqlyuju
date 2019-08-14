package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	public IndexController indexController;

	@Test
	public void select() {
		String s=indexController.select("李四",24);
		System.out.println(s);
	}

	@Test
	public void update() {
		String s=indexController.update(213,"王五",25);
		System.out.println(s);
	}

	@Test
	public void insert() {
		String s = indexController.insert("赵六", 26);
		System.out.println(s);
	}

	@Test
	public void delete1() {
		String s=indexController.delete1(142);
		System.out.println(s);
	}
}
