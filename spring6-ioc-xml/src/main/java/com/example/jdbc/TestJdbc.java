package com.example.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbc {
    @Test
    public void testDruid(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-jdbc.xml");

        DruidDataSource dataSource = context.getBean(DruidDataSource.class);

        System.out.println(dataSource.getUrl());
    }
}
