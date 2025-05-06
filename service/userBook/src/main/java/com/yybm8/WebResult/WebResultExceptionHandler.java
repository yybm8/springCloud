package com.yybm8.WebResult;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yybm8.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Component
public class WebResultExceptionHandler implements BlockExceptionHandler {
    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, String s, BlockException e) throws Exception {
       //设置响应内容类型为JSON格式，编码为UTF-8。
        response.setContentType("application/json;charset=utf-8");
        //获取响应的输出流，用于写入数据。
        PrintWriter writer = response.getWriter();
        //创建一个表示失败的结果对象，状态码为5000，消息为“服务器异常”。
        Result result = Result.fail();
        //将结果对象序列化为JSON字符串。
        String json = objectMapper.writeValueAsString(result);
        //将JSON字符串写入响应输出流。
        writer.write(json);
        //刷新并关闭输出流
        writer.flush();
        writer.close();
    }
}
