package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 1、根据 id 获取 Bean
        User user1 = (User) ac.getBean("user");
        System.out.println("1、根据 id 获取 Bean：" + user1);


        // 2、根据类型获取 Bean
        User user2 = (User) ac.getBean(User.class);
        System.out.println("2、根据类型获取 Bean：" + user2);

        // 3、根据 id 和类型获取 Bean
        User user3 = (User) ac.getBean("user", User.class);
        System.out.println("3、根据 id 和类型获取 Bean：" + user3);
    }
}
