package com.skillip.java.annotations.mapping;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MappingProcessor {
    public static void main(String[] args) throws IllegalAccessException {
        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Person person = new Person();
            person.setName("test");
            System.out.println(field.get(person));
            System.out.println(field.getName());
        }
    }
}
