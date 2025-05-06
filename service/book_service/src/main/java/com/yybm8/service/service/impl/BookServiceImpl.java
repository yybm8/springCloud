package com.yybm8.service.service.impl;

import com.yybm8.mapper.BookMapper;
import com.yybm8.pojo.Book;
import com.yybm8.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<Book> getBookById(Integer id) {
        return bookMapper.getBookById(id);
    }
}
