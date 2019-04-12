package com.skillip.jdbc.batch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchTest {
    long start;
    long end;

    @Test
    public void testBatch() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?rewriteBatchedStatements=true", "root", "");
        PreparedStatement pstat = conn.prepareStatement("insert into user(username, password) values (?, ?)");

        for (int i = 0; i < 10000; i++) {
            pstat.setString(1, "XXX" + i);
            pstat.setString(2, "ABC" + i);
            pstat.addBatch();

            if (i % 1000 == 0) {
                pstat.executeBatch();
                pstat.clearBatch();
            }
        }

        pstat.executeBatch();
        pstat.clearBatch();
    }

    @Before
    public void before() {
        start = System.currentTimeMillis();
    }

    @After
    public void after() {
        end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
    }
}
