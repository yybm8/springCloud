package com.yybm8.service.impl;


import com.yybm8.feign.BookFeignClient;
import com.yybm8.feign.UserFeignClient;
import com.yybm8.mapper.UserBookMapper;
import com.yybm8.pojo.*;
import com.yybm8.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBookServiceImpl implements UserBookService {

    @Autowired
    private UserBookMapper userBookMapper;
    @Qualifier("com.yybm8.feign.UserFeignClient")
    @Autowired
    private UserFeignClient userFeignClient;
    @Qualifier("com.yybm8.feign.BookFeignClient")
    @Autowired
    private BookFeignClient bookFeignClient;
    @Override
    public Result page(Pages pages) {
        int page=(pages.getPage()-1)*pages.getPageSize();
        int pageSize=pages.getPageSize();
        String book_name=pages.getBook_name();
        String book_author=pages.getBook_author();
        String username=pages.getUsername();
        String password=pages.getPassword();
        System.out.println(book_name+book_author+username+password);
        Result userResult=userFeignClient.UserGetAll();
        List<User> users=  (List<User>) userResult.getData();
        Result bookResult=bookFeignClient.BookGetAll();
        List<Book> books= (List<Book>) bookResult.getData();
        List<UserBookDTO> list=userBookMapper.getUserBookSelectAll(page,pageSize,book_name,book_author,username,password);
        Map<String,Object> map=new HashMap<>();
        map.put("users",users);
        map.put("books",books);
        map.put("page",list);
        if(list.isEmpty()){
            return Result.noData();
        }
        else{
            return Result.success(map);
        }


    }


}
