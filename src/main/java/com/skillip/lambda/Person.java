package com.skillip.lambda;

public class Person {
    private String name;
    private Integer sex;
    private  Integer age;
    private Integer salary;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Person(Integer i) {
        System.out.println(i);
    }

    public Person(String name, Integer sex, Integer age, Integer salary) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
