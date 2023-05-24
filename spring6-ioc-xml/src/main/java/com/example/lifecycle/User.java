package com.example.lifecycle;

public class User {
    public User() {
        System.out.println("1、Bean创建对象，调用无参构造");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2、给Bean对象设置属性值");
        this.name = name;
    }

    public void init(){
        System.out.println("4、Bean对象初始化，调用指定初始化方法");
    }

    public void destroy(){
        System.out.println("7、Bean对象销毁，调用指定销毁方法");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
