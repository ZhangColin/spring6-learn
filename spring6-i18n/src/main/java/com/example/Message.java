package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Message {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "GB"));

        String title = bundle.getString("title");
        System.out.println(title);

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        String message = context.getMessage("title", new Object[]{"文野", new Date()}, new Locale("en", "GB"));

        System.out.println(message);
    }
}
