package com.skillip.exam;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BasicQuestion {
    // 18、用实现Runnable接口的方式，启动一个线程完成在线程中打印1-100的数字
    @Test
    public void test18() {
        // 无法在单元测试中执行
    }

    // 17、请编写代码把一个GBK的文本文件内容读取后存储到一个UTF-8的文本文件中。
    @Test
    public void test17() throws Exception {
        FileInputStream fis = new FileInputStream("D:\\IdeaProjects\\java-tour\\src\\main\\resources\\test-gbk.txt");
        InputStreamReader isr = new InputStreamReader(fis, "gbk");

        FileOutputStream fos = new FileOutputStream("D:\\IdeaProjects\\java-tour\\src\\main\\resources\\test-utf8.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        char[] c = new char[1024];
        int len = 0;
        while ((len = isr.read(c)) != -1) {
            osw.write(c, 0, len);
            System.out.println(c);
        }

        osw.close();
        fos.close();

        isr.close();
        fis.close();


    }

    // 16、请编写代码读取一个项目根目录下info.properties文件
    // 里面的内容有user=skillip等，请获取user的value中，并在控制台打印
    @Test
    public void test16() {
        Properties p = new Properties();
        try {
            p.load(this.getClass().getClassLoader().getResourceAsStream("info.properties"));
            String user = p.getProperty("user");
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test15() {
        System.out.println("看资料里面");
    }


    // 14、把如下信息添加到Map中，并遍历显示，请正确指定泛型
    /*
    浙江省
        绍兴市
        温州市
        湖州市
        嘉兴市
        台州市
        金华市
        舟山市
        衢州市
        丽水市
    海南省
        海口市
        三亚市
    北京市
        北京市
     */
    @Test
    public void test14() {
        Map<String, List<String>> map = new HashMap<>(3);
        map.put("浙江省", Arrays.asList("绍兴市", "温州市", "湖州市", "嘉兴市", "台州市", "金华市", "舟山市", "衢州市", "丽水市"));
        map.put("海南省", Arrays.asList("海口市", "三亚市"));
        map.put("北京市", Arrays.asList("北京市"));


        map.forEach((k, v) -> {
            System.out.println(k);
            for (String city : v) {
                System.out.println("\t" + city);
            }
        });
    }

    // 13、写一段代码实现在遍历ArrayList时移除一个元素，例如：”java”？
    @Test
    public void test13() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("java");
        list.add("world");

//        int i = 0;
//        for(String str : list) {
//            if("java".equals(str)) {
//                list.remove(i);
//            }
//            ++i;
//        }

        Iterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if("java".equals(iterator.next())) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    @Test
    public void test12() {
        System.out.println("请看TestWeek");
    }


        // 7、请编写代码使用把一个字符串反转，例如：hello1234，反转后：4321olleh。
    @Test
    public void test07() {

    }


    @Test
    public void test06() {
        printStar(20);
    }

    public static void printStar(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2 * i -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
