package com.yybm8.controller;

import com.yybm8.pojo.Pages;
import com.yybm8.pojo.Result;
import com.yybm8.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @PostMapping("/page")
    public Result page(@RequestBody Pages pages){
        if(pages.getGoods_number()==null){
            pages.setGoods_number(0);
        }
        return goodsService.page(pages);
    }
}
