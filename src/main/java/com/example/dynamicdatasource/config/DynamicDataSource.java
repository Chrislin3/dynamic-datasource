package com.example.dynamicdatasource.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态的取出我们在切面里设置的数据源的字符串
 *
 * @author pangenshan
 * @version 1.0
 * @date 2019/1/7 16:51
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        log.debug("数据源为{}", DatasourceContextHolder.getDB());
        return DatasourceContextHolder.getDB();
    }
}