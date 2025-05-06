package com.yybm8.Interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class XTokenInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("XTokenInterceptor");
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}
