package com.yybm8;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootTest
public class text01 {

    @Autowired
    DiscoveryClient  discoveryClient;
    @Test
    void display(){
        for (String service:discoveryClient.getServices()) {
            System.out.println("service"+service);
        }
    }
}
