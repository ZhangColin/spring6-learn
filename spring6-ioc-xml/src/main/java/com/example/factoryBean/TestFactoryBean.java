package com.example.factoryBean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {
    @Test
    public void testFactoryBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factory-bean.xml");

        User user = context.getBean(User.class);

        System.out.println(user);
    }
}
