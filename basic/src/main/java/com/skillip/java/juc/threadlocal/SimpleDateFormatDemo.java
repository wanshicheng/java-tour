package com.skillip.java.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        Date date = new Date();
        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));
    }
}
