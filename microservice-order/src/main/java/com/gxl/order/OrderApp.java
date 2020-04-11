package com.gxl.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 申明这是一个Spring Boot项目：@SpringBootApplication
 * 手动指定bean扫描范围：basePackages = {"",""}
 *
 * @author gxl
 * @version 1.0
 * @description 订单服务入口
 * @date 2019-08-09 09:18
 */
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.gxl.order.controller", "com.gxl.order.service", "com.gxl.order.properties"})
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

    /**
     * 向Spring容器中定义RestTemplate对象
     *
     * @return org.springframework.web.client.RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
