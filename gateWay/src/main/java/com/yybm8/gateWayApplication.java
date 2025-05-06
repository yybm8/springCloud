package com.yybm8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient// 开启服务发现
@SpringBootApplication
public class gateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(gateWayApplication.class, args);
    }
}