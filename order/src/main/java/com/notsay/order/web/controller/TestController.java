package com.notsay.order.web.controller;

import com.notsay.order.web.controller.vo.OrderTestVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/5 11:20
 */
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/test1")
    public String helloTest(){
//        new Exploit();
        return "hello order-" + port;
    }

    @GetMapping("/test2")
    public OrderTestVO orderTest(){
        OrderTestVO orderTestVO = new OrderTestVO();
        orderTestVO.setName("订单1号");
        orderTestVO.setAmount(1000000L);
        return orderTestVO;
    }
}