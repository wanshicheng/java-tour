package com.skillip.java.enumuration;

public class Demo {
    public static void main(String[] args) {
        Type type1 = Type.TYPE1;
        type1.setName("10");
        System.out.println(type1.getName());
        System.out.println(type1.hashCode());
        type1.setName("1");
        System.out.println(type1.hashCode());
        System.out.println(type1.getName());
    }
}
