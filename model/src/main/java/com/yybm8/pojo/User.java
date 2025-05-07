package com.yybm8.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String age;
    private String sex;
    private Integer status;
    private List<Book> books;
}
