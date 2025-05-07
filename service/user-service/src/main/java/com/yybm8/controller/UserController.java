package com.yybm8.controller;

import com.yybm8.pojo.Pages;
import com.yybm8.pojo.Result;
import com.yybm8.pojo.User;
import com.yybm8.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public List<User> getUser(@PathVariable("id") Integer id,HttpServletRequest request
                              ){
        String Token = request.getHeader("X-Token");
        System.out.println("X-Token:"+Token);
        return userService.getUserById(id);
    }

    @PostMapping("/page")//分页
    public Result page(@RequestBody Pages pages){

        Integer page = pages.getPage();
        Integer pageSize = pages.getPageSize();
        String username = pages.getUsername();
        String password = pages.getPassword();
        if(page<=0&&pageSize<=0){
            page=1;
            pageSize=5;
        }
        return userService.page(page, pageSize, username, password);

    }
    @PostMapping("/insert")//添加
    public Result insert(@RequestBody User user){
        if(user.getUsername()==null&&user.getPassword()==null){
            return Result.noWork();
        }
        return userService.insert(user);
    }
    @PostMapping("/delete")//根据id或姓名或密码删除
    public Result delete(@RequestBody User user){
        if(user.getUsername()==null&&user.getPassword()==null&&user.getId()==null){
            return Result.noWork();
        }
        return userService.delete(user);
    }

    @PostMapping("/update")//根据传入的信息动态更新id必须传入
    public Result update(@RequestBody User user){
        if(user.getUsername()==null||user.getPassword()==null){
            return Result.noWork();
        }
        return userService.update(user);
    }

    @PostMapping("/UserGetAll")
    public Result UserGetAll(){
        return userService.getAll();
    }
}
