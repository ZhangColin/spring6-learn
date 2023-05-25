package com.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {

    @Test
    public void test01() throws Exception {
        Class<Car> carClass1 = Car.class;
        Class<? extends Car> carClass2 = new Car().getClass();
        Class<?> carClass3 = Class.forName("com.example.Car");

        Car car = carClass1.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    @Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Car> carClass = Car.class;

        Constructor<?>[] constructors = carClass.getConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName()+constructor.getParameterCount());
        }

        Constructor<Car> constructor = carClass.getConstructor(String.class, int.class, String.class);
        Car car = constructor.newInstance("BYD", 1, "银色");

        System.out.println(car);
    }

    @Test
    public void test03() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Car> carClass = Car.class;

        Constructor<Car> constructor = carClass.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Car car = constructor.newInstance("BYD", "银色");

        System.out.println(car);
    }

    @Test
    public void test04() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Car> carClass = Car.class;

        Field[] fields = carClass.getDeclaredFields();
        Car car = carClass.getDeclaredConstructor().newInstance();
        for (Field field : fields) {
            if (field.getName().equals("name")){
                field.setAccessible(true);
                field.set(car, "BYD");
            }
            System.out.println(field.getName());
        }

        System.out.println(car);
    }

    @Test
    public void test05() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Car> carClass = Car.class;

        Method[] methods = carClass.getDeclaredMethods();
        Car car = new Car("BYD", 1, "Red");
        for (Method method : methods) {
            if (method.getName().equals("toString")){
                System.out.println(method.invoke(car));
            }
            if (method.getName().equals("run")){
                method.setAccessible(true);
                method.invoke(car);
            }
            System.out.println(method.getName());
        }


    }
}
