package com.yybm8.service.impl;

import com.yybm8.mapper.GoodsMapper;
import com.yybm8.pojo.Goods;
import com.yybm8.pojo.Pages;
import com.yybm8.pojo.Result;
import com.yybm8.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public Result page(Pages pages) {
        int page=(pages.getPage()-1)*pages.getPageSize();
        int pageSize=pages.getPageSize();
        String goods_name=pages.getGoods_name();
        String goods_from=pages.getGoods_from();
        String goods_price=pages.getGoods_price();
        int goods_number=pages.getGoods_number();//在处理int值需要非常小心，int值不能为空，否则会报空指针异常
        List<Goods> goods = goodsMapper.page(page, pageSize, goods_name, goods_from, goods_price, goods_number);
        int count = goodsMapper.count(goods_name, goods_from, goods_price, goods_number);
        Map map=new HashMap();
        map.put("count",count);
        map.put("goods",goods);
        if(goods.isEmpty()){
            return Result.noData();
        }
        else{
            return Result.success(map);
        }
    }
}
