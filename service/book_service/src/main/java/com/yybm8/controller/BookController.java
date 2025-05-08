package com.yybm8.controller;

import com.yybm8.pojo.Book;
import com.yybm8.pojo.Pages;
import com.yybm8.pojo.Result;
import com.yybm8.service.BookPageService;
import com.yybm8.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookPageService bookPageService;

    @GetMapping("/book/{id}")
    public List<Book> getBook(@PathVariable("id") Integer id)
    {
        return bookService.getBookById(id);
    }

    @PostMapping("/page")
    public Result page(@RequestBody Pages pages)
    {
        int page=pages.getPage();
        int pageSize=pages.getPageSize();
        String book_name=pages.getBook_name();
        String book_author=pages.getBook_author();
        System.out.println(page+"//"+pageSize+book_name+book_author);
        return bookPageService.page(page,pageSize,book_name,book_author);
    }
    @PostMapping("/insert")
    public Result insert(@RequestBody Book book){
        if(book.getBook_name()==null&&book.getBook_author()==null){
            return Result.noWork();
        }
        return bookPageService.insert(book);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Book book){
        if(book.getBook_id()==null){
            return Result.noWork();
        }
        return bookPageService.delete(book);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Book book){
        if(book.getBook_id()==null){
            return Result.noWork();
        }
        return bookPageService.update(book);
    }
    @PostMapping("/BookGetAll")
    public Result BookGetAll(){
        return bookPageService.getAll();
    }
}
