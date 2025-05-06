package com.yybm8.service;

import com.yybm8.pojo.Book;
import com.yybm8.pojo.BookPages;
import com.yybm8.pojo.Result;

public interface BookPageService {
    Result page(int page,int pageSize,String book_name,String book_author);

    Result insert(Book book);

    Result delete(Book book);

    Result update(Book book);
}
