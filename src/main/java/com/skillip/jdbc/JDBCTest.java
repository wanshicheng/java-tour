package com.skillip.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCTest {
    @Test
    public void test() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?useUnicode=true&amp;characterEncoding=UTF-8",
                    "root", "");
            String sql = "select * from beauty where id = ?;";
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1, 1);
            pstat.executeQuery();

            ResultSet rs = pstat.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
