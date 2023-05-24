package com.example.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void testLifecycle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life-cycle.xml");

        User user = context.getBean(User.class);

        System.out.println("6、Bean 对象创建完成");

        System.out.println(user);

        context.close();
    }
}
