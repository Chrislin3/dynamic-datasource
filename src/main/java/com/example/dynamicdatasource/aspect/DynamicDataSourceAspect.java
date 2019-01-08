package com.example.dynamicdatasource.aspect;

import com.example.dynamicdatasource.annotation.RoutingDataSource;
import com.example.dynamicdatasource.config.DatasourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * aop 拦截注解
 *
 * @author pangenshan
 * @version 1.0
 * @date 2019/1/8 9:06
 */
@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {
    @Before("@annotation(com.example.dynamicdatasource.annotation.RoutingDataSource)")
    public void beforeSwitchDS(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String dataSource = DatasourceContextHolder.DEFAULT_DATASOURCE;
        if (method.isAnnotationPresent(RoutingDataSource.class)) {
            RoutingDataSource routingDataSource = method.getDeclaredAnnotation(RoutingDataSource.class);
            dataSource = routingDataSource.value();
        }
        DatasourceContextHolder.setDB(dataSource);
    }

    /**
     * 方法使用完后，要清空DatasourceContextHolder
     */
    @After("@annotation(com.example.dynamicdatasource.annotation.RoutingDataSource)")
    public void afterSwitchDS() {
        DatasourceContextHolder.clearDB();
    }
}