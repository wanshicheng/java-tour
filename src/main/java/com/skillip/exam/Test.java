package com.skillip.exam;

public class Test {
    public static void main(String[] args) {
        Base b1 = new Base();
        Base b2 = new Sub();
    }
}

class Base {
    Base () {
        method(100);
    }

    public void method(int i) {
        System.out.println("base:" + i);
    }
}

class Sub extends Base{
    Sub () {
        super.method(70);
    }

    @Override
    public void method(int i) {
        System.out.println("sub:" + i);
    }
}