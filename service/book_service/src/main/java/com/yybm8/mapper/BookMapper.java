package com.yybm8.mapper;

import com.yybm8.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> getBookById(Integer id);

    int selectCount(@Param("book_name") String book_name, @Param("book_author") String book_author);

    List<Book> selectAll(@Param("page")Integer page, @Param("pageSize")Integer pageSize, @Param("book_name") String book_name, @Param("book_author") String book_author);

    boolean insert( @Param("book_name") String book_name, @Param("book_author") String book_author);

    boolean delete(@Param("book_id") int book_id,@Param("book_name") String book_name, @Param("book_author") String book_author);

    boolean update( @Param("book_id") int book_id,@Param("book_name") String book_name, @Param("book_author") String book_author);
}
