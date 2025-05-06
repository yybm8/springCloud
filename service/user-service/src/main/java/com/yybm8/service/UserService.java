package com.yybm8.service;
import com.yybm8.pojo.Result;
import com.yybm8.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getUserById(Integer id);

    Result page(Integer page, Integer pageSize, String username, String password);

    Result insert(User user);

    Result delete(User user);

    Result update(User user);
}
