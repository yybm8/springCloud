package com.yybm8.feign;


import com.yybm8.feign.fallback.UserBookFeignClientFallBack;
import com.yybm8.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
@FeignClient(value = "user-service",fallback = UserBookFeignClientFallBack.class)//专门用于调用user-service服务
public interface UserFeignClient {

    //mvc两套使用逻辑
    //标注在Controller上，是接受这样的请求
    //标注在FeignClient上，是发送这样的请求
    //将id放到请求中，将token放到请求头中
    //括号内id和token是建
    @GetMapping("/api/user/user/{id}")
    List<User> getUser(@PathVariable("id") Integer id);
}
