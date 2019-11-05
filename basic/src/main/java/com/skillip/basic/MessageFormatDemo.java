package com.skillip.basic;

import org.junit.Test;

import java.text.MessageFormat;

/**
 * https://blog.csdn.net/qq_36538061/article/details/78506758
 */
public class MessageFormatDemo {
    /**
     * ArgumentIndex必须是非负整数，它的个数不只限于0到9这10个，它可以用0到9的数字组成，因此可以有好多个，如：
     */
    @Test
    public void test1() {
        String msg = "{0}{1}{2}{3}{4}{5}{6}{7}{8}";
        Object[] array = new Object[]{"A","B","C","D","E","F","G","H","I",};
        String value = MessageFormat.format(msg, array);
        System.out.println(value);
    }

    /**
     * 格式化字符串时，两个单引号才表示一个单引号，单个单引号会被省略，除非中文单引号不会被省略
     * 显示双引号，需要转义
     */
    @Test
    public void test2() {
        String value1 = MessageFormat.format("oh, {0} is 'a' pig", "ZhangSan");
        System.out.println(value1);  // 输出：oh, ZhangSan is a pig

        String value2 = MessageFormat.format("oh, {0} is ''a'' pig", "ZhangSan");
        System.out.println(value2);  // 输出：oh, ZhangSan is 'a' pig

        String value3 = MessageFormat.format("oh, {0} is \"a\" pig", "ZhangSan");
        System.out.println(value3);  // 输出：oh, ZhangSan is "a" pig
    }

    /**
     * 单引号会使其后面的占位符均失效，导致直接输出占位符。
     */
    @Test
    public void test3() {
        String value1 = MessageFormat.format("{0}{1}", 1, 2);
        String value2 = MessageFormat.format("'{0}{1}", 1, 2);
        String value3 = MessageFormat.format("'{0}'-{1}", 1, 2);
        System.out.println(value1); // 结果12
        System.out.println(value2); // 结果{0}{1}
        System.out.println(value3); // 结果{0}-2
    }
}
