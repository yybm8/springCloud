package com.yybm8.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pages {
    private Integer page;
    private Integer pageSize;
    private String username;
    private String password;
    private String book_name;
    private String book_author;
    private String goods_name;
    private String goods_from;
    private String goods_price;
    private Integer goods_number;

}
