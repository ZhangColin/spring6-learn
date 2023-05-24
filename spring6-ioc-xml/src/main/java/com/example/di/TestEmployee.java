package com.example.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestEmployee {
    @Test
    public void testOuterBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.outer.xml");

        Employee employee = context.getBean(Employee.class);

        employee.work();
    }
    @Test
    public void testInnerBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.inner.xml");

        Employee employee = context.getBean(Employee.class);

        employee.work();
    }
    @Test
    public void testArrayBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.array.xml");

        Employee employee = context.getBean(Employee.class);

        employee.work();

        System.out.println(Arrays.toString(employee.getLoves()));
    }
    @Test
    public void testListBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.list.xml");

        Department department = context.getBean(Department.class);

        System.out.println(Arrays.toString(department.getEmployees().stream().map(Employee::getName).toArray()));
    }
    @Test
    public void testMapBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.map.xml");

        Student student = context.getBean(Student.class);

        System.out.println(student.getTeacherMap());
    }


    @Test
    public void testRefBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.ref.xml");

        Department department = context.getBean(Department.class);

        System.out.println(Arrays.toString(department.getEmployees().stream().map(Employee::getName).toArray()));


        Student student = context.getBean(Student.class);

        System.out.println(student.getTeacherMap());
    }
}
