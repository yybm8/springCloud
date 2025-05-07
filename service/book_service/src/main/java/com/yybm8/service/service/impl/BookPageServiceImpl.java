package com.yybm8.service.service.impl;

import com.yybm8.mapper.BookMapper;
import com.yybm8.pojo.Book;
import com.yybm8.pojo.Result;
import com.yybm8.service.BookPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookPageServiceImpl implements BookPageService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Result page(int page, int pageSize, String book_name, String book_author) {
        System.out.println(book_name+book_author);
        int count=bookMapper.selectCount(book_name,book_author);
        List<Book> book=bookMapper.selectAll(page,pageSize,book_name,book_author);
        Map boot1=new HashMap();
        boot1.put("count",count);
        boot1.put("book",book);
        if(book.isEmpty()){
            return Result.noData();
        }
        else{
            return Result.success(boot1);
        }
    }

    @Override
    public Result insert(Book book) {
        if(book.getBook_name()==null&&book.getBook_author()==null){
            return Result.noWork();
        }
        String book_name=book.getBook_name();
        String book_author=book.getBook_author();

        return bookMapper.insert(book_name,book_author)?Result.yesWork():Result.fail();
    }

    @Override
    public Result delete(Book book) {
        int book_id=book.getBook_id();
        String book_name=book.getBook_name();
        String book_author=book.getBook_author();
        return bookMapper.delete(book_id,book_name,book_author)?Result.yesWork():Result.fail();
    }

    @Override
    public Result update(Book book) {
        int book_id=book.getBook_id();
        String book_name=book.getBook_name();
        String book_author=book.getBook_author();
        return bookMapper.update(book_id,book_name,book_author)?Result.yesWork():Result.fail();
    }

    @Override
    public Result getAll() {
        List<Book> book=bookMapper.getBookSelectAll();
        if(book.isEmpty()){
            return Result.noData();
        }
        else{
            return Result.success(book);
        }
    }

}
