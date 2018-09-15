package com.zh.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * H2DataBaseTest
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/7/15:19
 */
public class H2DataBaseTest {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = H2DataBaseTest.class.getResourceAsStream("/application.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String driverClass = properties.getProperty("spring.h2.driverClass");
        String jdbcUrl = properties.getProperty("spring.h2.jdbcUrl");
        String username = properties.getProperty("spring.h2.username");
        String password = properties.getProperty("spring.h2.password");
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
//        String sql = "CREATE TABLE  student(ID INT , NAME VARCHAR(100))";
//        String sql = "INSERT INTO student VALUES(1,'张三')";
        String sql = "SELECT NAME FROM student WHERE ID = 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        preparedStatement.execute();
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }



    public void startH2(){

    }
}
