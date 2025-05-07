package com.yybm8.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private Integer book_id;
    private String book_name;
    private String book_author;
    private List<User> users;
}
