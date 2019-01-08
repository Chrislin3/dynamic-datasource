package com.example.dynamicdatasource.controller;

import com.example.dynamicdatasource.domain.SysUser;
import com.example.dynamicdatasource.service.DataSourceRoutingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author pangenshan
 * @version 1.0
 * @date 2019/1/8 9:30
 */
@RestController
@RequestMapping("/route")
public class DataSourceRoutingController {
    @Resource
    private DataSourceRoutingService dataSourceRoutingService;

    @GetMapping("/test1")
    public SysUser test1(long id) {
        return dataSourceRoutingService.test1(id);
    }

    @GetMapping("/test2")
    public SysUser test2(long id) {
        return dataSourceRoutingService.test2(id);
    }
}