package com.example.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder {
    @Test
    public void TestSingleton(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");

        Order order = context.getBean("order", Order.class);
        System.out.println(order);
        Order order1 = context.getBean("order", Order.class);
        System.out.println(order1);
    }
}
