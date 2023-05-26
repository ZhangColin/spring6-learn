package com.example.user;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    @Test
    public void testValidation1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 validation1 = context.getBean(MyValidation1.class);

        User user = new User();
        boolean validate = validation1.validate(user);

        System.out.println(validate);
    }

    @Test
    public void testValidation2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);

        User user = new User();
        user.setName("colin");
        boolean validate = validation2.validate(user);

        System.out.println(validate);
    }
}
