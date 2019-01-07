package com.example.dynamicdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author pangenshan
 * @version 1.0
 * @date 2019/1/7 16:36
 */
@Configuration
public class DatasourceConfig {
    @Bean(destroyMethod = "close", name = Datasources.MASTER_DB)
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(destroyMethod = "close", name = Datasources.SLAVE_DB)
    @ConfigurationProperties(prefix = "spring.datasourceSlave")
    public DataSource dataSourceSlave() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
}