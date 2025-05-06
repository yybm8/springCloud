package com.yybm8.mapper;

import com.yybm8.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> getBookById(Integer id);
}
