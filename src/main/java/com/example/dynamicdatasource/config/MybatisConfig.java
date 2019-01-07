package com.example.dynamicdatasource.config;

import com.example.dynamicdatasource.config.Datasources;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * mybatis 配置
 *
 * @author pangenshan
 * @version 1.0
 * @date 2019/1/7 16:43
 */
@Configuration
@MapperScan(basePackages = {"com.example.dynamicdatasource.dao"})
public class MybatisConfig {
    @Resource
    @Qualifier(Datasources.MASTER_DB)
    private DataSource masterDB;

    @Resource
    @Qualifier(Datasources.SLAVE_DB)
    private DataSource slaveDB;

    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        return null;
    }
}
