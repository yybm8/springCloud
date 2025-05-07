package com.yybm8.feign.fallback;

import com.yybm8.feign.BookFeignClient;
import com.yybm8.pojo.Result;
import org.springframework.stereotype.Component;


@Component
public class BookFeignClientFallBack implements BookFeignClient {
    @Override
    public Result BookGetAll() {
        return Result.noWork();
    }
}
