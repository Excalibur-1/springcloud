package com.zpc.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 申明这是一个Eureka服务：@EnableEurekaServer
 *
 * @author gxl
 * @version 1.0
 * @description Eureka注册中心
 * @date 2019-08-09 08:44
 */
@EnableEurekaServer
@SpringBootApplication
public class AppEureka {

    public static void main(String[] args) {
        SpringApplication.run(AppEureka.class, args);
    }
}

