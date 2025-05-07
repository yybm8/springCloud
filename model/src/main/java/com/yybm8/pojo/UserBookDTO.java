package com.yybm8.pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserBookDTO {
    private Integer UB_id;
    private List<User> users;
    private List<Book> books;
}
