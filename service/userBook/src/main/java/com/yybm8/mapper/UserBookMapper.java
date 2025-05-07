package com.yybm8.mapper;

import com.yybm8.pojo.Result;
import com.yybm8.pojo.UserBookDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserBookMapper {


    List<UserBookDTO> getUserBookSelectAll(@Param("page")int page, @Param("pageSize")int pageSize, @Param("bookName")String bookName, @Param("bookAuthor")String bookAuthor, @Param("username")String username, @Param("password")String password);
}
