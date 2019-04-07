package com.skillip.lambda.demo;

import org.junit.Test;

import java.util.function.*;

public class FunctionalInterfaceTest {
    @Test
    public void test6() {
        BinaryOperator<Integer> bo = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i1, Integer i2) {
                return i1 + i2;
            }
        };

        bo = (x1, x2) -> x1 + x2;
        System.out.println(bo.apply(1,2));

    }

    @Test
    public void test5() {
        UnaryOperator<Integer> uo = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer;
            }
        };

        uo = t -> t + 1;
        System.out.println(uo.apply(1));
    }

    /*
     * Predicate  需要一个参数，返回boolean值
     * 泛型就是方法的形参类型
     */
    @Test
    public void test4(){
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return "aa".equals(t);
            }
        };
        System.out.println("-------------lambda--------------");
        predicate = t -> "aa".equals(t);

        boolean flag = predicate.test("aa");
        System.out.println(flag);
    }

    /*
     * Function  需要一个参数，有返回值
     * 第一个泛型参数是形参类型，第二个泛型类型是返回值类型
     */
    @Test
    public void test3(){
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer t) {
                return String.valueOf(t);
            }
        };
        System.out.println("------------lambda--------------");
        function = t -> String.valueOf(t);
    }

    /*
     * Supplier  没有参数，有返回值
     * 泛型就是方法的返回值类型
     */
    @Test
    public void test2(){
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int)(Math.random()*100);
            }
        };

        System.out.println("----------lambda----------");
        supplier = () -> (int)(Math.random()*100);
    }

    /*
     *  函数式接口：consumer   一个参数，没有返回值
     *  泛型就是方法形参的类型
     */
    @Test
    public void test1() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println("Hello Consumer...");
            }
        };
        System.out.println("------------lambda----------------");
        consumer = t -> System.out.println("Hello Consumer..." + t);
        consumer.accept("test");
    }
}

