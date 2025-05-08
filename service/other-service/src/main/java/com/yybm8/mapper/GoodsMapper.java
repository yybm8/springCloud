package com.yybm8.mapper;

import com.yybm8.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> page(@Param("page")int page, @Param("page_size")int page_size,@Param("goods_name") String goods_name, @Param("goods_from")String goods_from,@Param("goods_price") String goods_price, @Param("goods_number")int goods_number);

    int count(@Param("goods_name") String goods_name, @Param("goods_from")String goods_from,@Param("goods_price") String goods_price, @Param("goods_number")int goods_number);
}
