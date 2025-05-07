package com.yybm8.feign;

import com.yybm8.feign.fallback.BookFeignClientFallBack;
import com.yybm8.feign.fallback.UserBookFeignClientFallBack;
import com.yybm8.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(value = "book-service",fallback = BookFeignClientFallBack.class)//专门用于调用book-service服务
public interface BookFeignClient {
    @PostMapping("api/book/BookGetAll")
     Result BookGetAll();
}
