package com.skillip.lambda.demo;

/*
 * 以后编写javabean都必须重写hashCode和equals方法
 * 必须给无参的构造器
 */
public class Person {
    private String name;
    private Integer sex;
    private Integer age;
    private Integer salary;
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        if (sex == null) {
            if (other.sex != null)
                return false;
        } else if (!sex.equals(other.sex))
            return false;
        return true;
    }
    public Person(String name, Integer sex, Integer age, Integer salary) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }
    public Person() {
        super();
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", sex=" + sex + ", age=" + age + ", salary=" + salary + "]";
    }


}
