package com.rainbowsea.config;


import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 配置切换，Druid 数据库连接池
 */
@Configuration  // 标志配置类
public class DruidDataSourceConfig {


    @Bean  // 被 Spring ioc 容器管理起来
    @ConfigurationProperties(value = "spring.datasource")
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();

        return druidDataSource;
    }
}
