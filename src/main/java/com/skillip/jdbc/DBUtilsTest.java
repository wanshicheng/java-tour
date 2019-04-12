package com.skillip.jdbc;

import com.skillip.jdbc.pojo.Employee;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class DBUtilsTest {
    QueryRunner qr ;
    RowProcessor processor;


    @Test
    public void test() throws Exception {
        String sql = "select * from employee";
        List<Employee> employees = qr.query(JDBCTools.getConnection(), sql, new BeanListHandler<Employee>(Employee.class, processor));
        for(Employee e : employees) {
            System.out.println(e);
        }
    }

    @Before
    public void init() {
        qr = new QueryRunner();
        BeanProcessor bean = new GenerousBeanProcessor();
        processor = new BasicRowProcessor(bean);
    }
}
