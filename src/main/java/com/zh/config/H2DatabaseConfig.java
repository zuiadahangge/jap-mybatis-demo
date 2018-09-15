package com.zh.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * H2DatabaseConfig
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/7/16:39
 */
@Configuration
public class H2DatabaseConfig {
    private static final Logger log = Logger.getLogger(H2DatabaseConfig.class);

    final private String SQL=
            "drop table student if exists ;" +
            "create table student (ID INT , NAME VARCHAR(100))";

    @Resource
    private DataSource dataSource;
    @PostConstruct
    public void createTable(){
        log.info("H2嵌入式数据库初始化---------开始---------");
        log.info(SQL);
        try {
            PreparedStatement preparedStatement =dataSource.getConnection().prepareStatement(SQL);
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error("H2嵌入式数据库初始化------失败------------");
            e.printStackTrace();
        }
        log.info("H2嵌入式数据库初始化---------完成---------");
    }
}
