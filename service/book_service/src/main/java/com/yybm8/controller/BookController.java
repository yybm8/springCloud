package com.yybm8.controller;

import com.yybm8.pojo.Book;
import com.yybm8.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/book/{id}")
    public List<Book> getBook(@PathVariable("id") Integer id)
    {
        return bookService.getBookById(id);
    }
}
