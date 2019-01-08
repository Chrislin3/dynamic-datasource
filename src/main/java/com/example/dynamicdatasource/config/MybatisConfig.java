package com.example.dynamicdatasource.config;

import com.google.common.collect.Maps;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

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

    /**
     * 多数据源配置
     *
     * @return DataSource
     */
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDB);
        Map<Object, Object> dsMap = Maps.newHashMap();
        dsMap.put(Datasources.MASTER_DB, masterDB);
        dsMap.put(Datasources.SLAVE_DB, slaveDB);
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return sqlSessionFactoryBean;
    }
}