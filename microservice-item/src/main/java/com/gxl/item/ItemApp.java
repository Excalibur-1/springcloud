package com.gxl.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 申明这是一个Spring Boot项目：@SpringBootApplication
 * 手动指定bean组件扫描范围：basePackages = {"",""}
 *
 * @author gxl
 * @version 1.0
 * @description 商品服务入口
 * @date 2019-08-09 08:57
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.gxl.item.controller", "com.gxl.item.service"})
public class ItemApp {

    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class, args);
    }
}

