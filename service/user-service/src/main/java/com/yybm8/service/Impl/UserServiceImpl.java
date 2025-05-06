package com.yybm8.service.Impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yybm8.mapper.UserMapper;
import com.yybm8.pojo.Result;
import com.yybm8.pojo.User;
import com.yybm8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private UserMapper usermapper;



    @SentinelResource(value="createSentinel",blockHandler = "createSentinelFallback")
    @Override
    public List<User> getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public List<User> createSentinelFallback(Integer id, BlockException e){
        User user=new User();
        user.setUsername("兜底回调调用user-service服务失败");
        user.setPassword("兜底回调调用user-service服务失败");
        user.setId(id);
        List<User> a=new ArrayList<>();
        a.add(user);
        return a;
    }

    @Override
    public Result page(Integer page, Integer pageSize, String username, String password) {
        System.out.println("page:"+page+"pageSize:"+pageSize+"aaa"+username+"bbb"+password);
        int count = usermapper.selectCount(username,password);
        page=(page-1)*pageSize;
        List<User> user=usermapper.selectAll(page,pageSize,username,password);
        Map<String,Object> map=new HashMap<>();
        map.put("data",user);
        map.put("count",count);
        if(user.isEmpty()){
            return  Result.noData();
        }
        else{
            return Result.success(map);
        }

    }

    @Override
    public Result insert(User user) {
        boolean a = usermapper.insert(user);
        return IF(a);
    }

    @Override
    public Result delete(User user) {
        boolean a = usermapper.delete(user);
        return IF(a);
    }

    @Override
    public Result update(User user) {
        boolean a = usermapper.update(user);
        return IF(a);
    }

    public Result IF(boolean a){
        if(a) {
            return Result.yesWork();
        }
        else{
            return Result.noWork();
        }
    }
}
