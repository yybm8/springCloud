package com.yybm8.controller;

import com.yybm8.feign.UserFeignClient;
import com.yybm8.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userBook")
public class UserBookController {
    @Qualifier("com.yybm8.feign.UserFeignClient")
    @Autowired
    private UserFeignClient userFeignClient;
    @GetMapping("/userBooks/{id}")
    public List<User> getUser(@PathVariable("id") Integer id)
    {

        return userFeignClient.getUser(id);
    }
}
