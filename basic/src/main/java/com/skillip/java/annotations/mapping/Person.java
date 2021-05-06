package com.skillip.java.annotations.mapping;


public class Person {
    @Mapping(name = "person_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
