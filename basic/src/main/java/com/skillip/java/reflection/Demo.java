package com.skillip.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.skillip.java.reflection.Student");
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
            try {
                Constructor<?> constructor = clazz.getConstructor(int.class, String.class);
                Person person = (Person) constructor.newInstance(1, "test");
                System.out.println(person.getName());
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
