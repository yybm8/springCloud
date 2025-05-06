package com.yybm8.pojo;

import lombok.Data;

@Data
public class BookPages {
    private Integer page;
    private Integer pageSize;
    private String book_name;
    private String book_author;

}
