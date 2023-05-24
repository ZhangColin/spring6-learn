package com.example.di;

import java.util.List;

public class Department {
    private List<Employee> employees;

    private String name;

    public void info() {
        System.out.println("部门名称："+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
