package com.example.demo;

import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {
    @RequestMapping("/insert")
    public String insert(String name, int age) {
        List<Person> list = new ArrayList<>();
        try {
            System.out.println("insert start" + name + "," + age);
            Class.forName("com.mysql.jdbc.Driver");
            String jdbc = "jdbc:mysql://127.0.0.1:3306/mao?characterEncoding=GBK";
            Connection conn = DriverManager.getConnection(jdbc, "root", "123456789");
            Statement state = conn.createStatement();
            String sql = "insert into user (name,age)values('" + name + "'," + age + ")";
            System.out.println(sql);
            state.executeUpdate(sql);
            Person p = new Person();
            p.setName(name);
            p.setAge(age);
            list.add(p);
            conn.close();

        } catch (Exception e) {
            System.err.println(e);
            return "error";
        }
        System.out.println("执行了添加方法");
        return list.toString();
    }
   @RequestMapping("/delete1")
    public String delete1(int id) {
        List<Person> list = new ArrayList<Person>();
        try {
            System.out.println("delete1 start" + id);
            Class.forName("com.mysql.jdbc.Driver");
            String jdbc = "jdbc:mysql://127.0.0.1:3306/mao?characterEncoding=GBK";
            Connection conn = DriverManager.getConnection(jdbc, "root", "123456789");

            Statement state = conn.createStatement();
            String sql = "delete from user where id=" + id;
            System.out.println(sql);
            System.out.println("删除了");
            state.executeUpdate(sql);

            String selectSql1 = "select * from user where  id=" + id;

            ResultSet rs = state.executeQuery(selectSql1);
            while (rs.next()) {
                Person p1 = new Person();
                //int id1 = rs.getInt("id");
                p1.setId(Integer.parseInt(rs.getString("id")));
                p1.setName(rs.getString("name"));
                //  p1.setAge(Integer.parseInt(rs.getString("age")));
                list.add(p1);
            }

            conn.close();

        } catch (Exception e) {
            System.err.println(e);
            return "error";
        }
        System.out.println("执行了刪除方法");
        return list.toString();

    }
    @RequestMapping("/update")
    public String update(int id, String name, int age) {
        List<Person> list = new ArrayList<Person>();
        try {
            System.out.println("update start:" + id + "," + name + "," + age);
            Class.forName("com.mysql.jdbc.Driver");
            String jdbc = "jdbc:mysql://127.0.0.1:3306/mao?characterEncoding=GBK";
            Connection conn = DriverManager.getConnection(jdbc, "root", "123456789");
            Statement state = conn.createStatement();
            String sql = "update user set name='" + name + "',age=" + age + " where id=" + id;
            System.out.println(sql);
            state.executeUpdate(sql);

            String selectSql = "select * from user where  id=" + id;

            ResultSet rs = state.executeQuery(selectSql);
            while (rs.next()) {
                Person p = new Person();
                //int id1 = rs.getInt("id");
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setName(rs.getString("name"));
                p.setAge(Integer.parseInt(rs.getString("age")));
                list.add(p);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }
        System.out.println("执行了修改方法");
        return list.toString() ;
    }
    @RequestMapping("/select")
    public String select (String name,int age){
        // String a = "";
        List<Person> list = new ArrayList<Person>();
        try {
            System.out.println("select start");
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            String jdbc = "jdbc:mysql://127.0.0.1:3306/mao?characterEncoding=GBK";
            Connection conn = DriverManager.getConnection(jdbc, "root", "123456789");//链接到数据库
            Statement state = conn.createStatement();   //容器

            String sql = "select * from user where name='" + name + "' and age=" + age;
            if (isaBoolean(name) && age > 0) {
                sql = "select * from user where   age=" + age;
            }
            if (!isaBoolean(name) && age <= 0) {
                sql = "select * from user where name='" + name+"'" ;
            }

            System.out.println(sql);
            System.out.println("查看了");

            ResultSet rs = state.executeQuery(sql);         //将sql语句上传至数据库执行

            while (rs.next()) {
                Person p = new Person();
                //int id1 = rs.getInt("id");

                p.setName(rs.getString("name"));
                p.setAge(Integer.parseInt(rs.getString("age")));

                list.add(p);

            }
            rs.close();
            state.close();
            conn.close();//关闭通道
        } catch (Exception e) {
            System.err.println(e);
            return "error";
        }
        System.out.println("执行了查询方法");
        //return "1:zhangsan:12 <br/> 2:zhangsan2:11";list
        return list.toString() ;
    }

    private boolean isaBoolean (String name){
        return "".equals(name) || name == null;
    }
}


