package com.skillip.jdbc.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidTest {
    Connection conn;

    @Test
    public void test02() throws Exception{
        String sql = "select * from employee where emp_id=?";
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1,1);
        ResultSet rs = pstat.executeQuery();
        while (rs.next()) {
            String fName = rs.getString(2);
            System.out.println(fName);
        }

    }
    @Test
    public void test01() throws Exception{
        String sql = "select * from employee";
        PreparedStatement pstat = conn.prepareStatement(sql);
        ResultSet rs = pstat.executeQuery();
        while (rs.next()) {
            String fName = rs.getString(2);
            System.out.println(fName);
        }
    }

    @Before
    public void init() throws Exception {
        Properties properties = new Properties();
        properties.load(DruidTest.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        conn = ds.getConnection();

    }
}
