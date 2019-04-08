package com.skillip.lambda;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class LambdaTest {
    public static void main(String[] args) {
//        Integer[] datas = {1, 2, 3, 4, 5};
//        List<Integer> list = Arrays.asList(datas);
//        list.add(new Integer(5));
//        System.out.println(list.get(0).getClass());

        Function<Integer, Person> f = Person::new;

        System.out.println(f.getClass());
    }
}
