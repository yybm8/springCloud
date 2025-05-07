package com.yybm8.feign.fallback;

import com.yybm8.feign.UserFeignClient;
import com.yybm8.pojo.Result;
import com.yybm8.pojo.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserBookFeignClientFallBack implements UserFeignClient {
    @Override
    public List<User> getUser(Integer id) {
        System.out.println("兜底回调调用user-service服务失败");
        List<User> a =new ArrayList<>();
        User u1=new User();
        u1.setUsername("兜底回调调用user-service服务失败");
        u1.setPassword("兜底回调调用user-service服务失败");
        u1.setId(id);
        a.add(u1);
        return a;
    }

    @Override
    public Result UserGetAll() {
        return Result.noWork();
    }
}
