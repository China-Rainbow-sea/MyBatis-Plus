package com.rainbowsea.config;



import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration  // 标注配置类
public class DruidDataSourceConfig {

    @Bean
    @ConfigurationProperties(value = "spring.datasource")
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();

        return druidDataSource;
    }
}
