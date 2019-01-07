package com.example.dynamicdatasource.annotation;

import com.example.dynamicdatasource.config.Datasources;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源切换注解
 *
 * @author pangenshan
 * @version 1.0
 * @date 2019/1/7 15:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RoutingDataSource {
    String value() default Datasources.MASTER_DB;
}