package com.yybm8.mapper;

import com.yybm8.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from springcloud.user where user.user_id=#{id}")
    List<User> getUserById(Integer id);

    List<User> selectAll(@Param("page")Integer page, @Param("pageSize")Integer pageSize, @Param("username") String username, @Param("password") String password);

    int selectCount(@Param("username") String username, @Param("password") String password);

    boolean insert(User user);

    boolean delete(User user);

    boolean update(User user);
}
