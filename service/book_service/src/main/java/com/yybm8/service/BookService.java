package com.yybm8.service;

import com.yybm8.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookById(Integer id);
}
