package com.skillip.java.reflection;

public class Student extends Person {
    private int id;

    public Student(int id, String name) {
        super(name);
        this.id = id;
    }

    public void sayHello() {
        System.out.println(id + "," + name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
