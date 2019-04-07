package com.skillip.lambda.demo;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ReferrenceTest {

    //类::实例方法名
    @Test
    public void test3(){

        int[] ints = new int[3];
        System.out.println(ints.length);

        new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // public int compareTo(String anotherString)
                return o1.compareTo(o2);
            }
        };
        System.out.println("----------lambda------------");
        Comparator<String> c = (o1,o2) -> o1.compareTo(o2);
        System.out.println("------方法引用-------------");
        //String :: compareTo;   等同于  String :: (形参1调用者)compareTo（形参2方法的形参）;
        Comparator<String> c2 = String :: compareTo;
        System.out.println(c2.compare("a", "b"));
    }



    //类::静态方法名
    @Test
    public void test2(){
        new Supplier<Double>() {
            @Override
            public Double get() {
                // public static double random()
                return Math.random();
            }
        };
        System.out.println("-----------lambda----------");
        Supplier<Double> s = () -> Math.random();

        System.out.println("------------方法引用-----------");
        Supplier<Double> s2 = Math :: random;
        System.out.println(s2.get());
    }

    /*
     * 对象::实例方法名
     */
    @Test
    public void test1(){
        new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t);
                // public void println(String x) {
            }
        };
        System.out.println("---------lambda----------");
        Consumer<String> cs = t -> System.out.println(t);

        System.out.println("-----------------方法引用-------------");
        Consumer<String> cs2 = System.out::println;
        cs2.accept("hello atguigu~~~");
    }
}
