package com.skillip.tour.hikaricp;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/simpsons");
//        config.setUsername("bart");
//        config.setPassword("51mp50n");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//
//        HikariDataSource ds = new HikariDataSource(config);
//        try {
//            Connection connection = ds.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }


        BigDecimal num1 = BigDecimal.valueOf(0D);
        BigDecimal num2 = BigDecimal.valueOf(0D);
        System.out.println(System.identityHashCode(num1));
        System.out.println(num1);
        System.out.println(System.identityHashCode(num2));
        System.out.println(num2);
        System.out.println(System.identityHashCode(num1.add(BigDecimal.valueOf(1D))));
        System.out.println(num1);
        System.out.println(num2);
    }
}
