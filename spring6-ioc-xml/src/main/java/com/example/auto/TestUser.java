package com.example.auto;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void testAuto(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");

        UserController controller = context.getBean(UserController.class);

        controller.addUser();
    }
}
