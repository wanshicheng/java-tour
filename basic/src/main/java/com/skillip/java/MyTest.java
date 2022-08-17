package com.skillip.java;

import java.util.concurrent.CopyOnWriteArrayList;

public class MyTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Long> longs = new CopyOnWriteArrayList<>();
        longs.add(1L);
        longs.add(2L);

        for (Long aLong : longs) {
            longs.remove(aLong);
        }

        System.out.println(longs.size());
    }
}
