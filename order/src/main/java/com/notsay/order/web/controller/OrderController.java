package com.notsay.order.web.controller;

import com.notsay.order.domain.dto.OrderSaveDTO;
import com.notsay.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 17:13
 */
@RestController
@RequestMapping("/api/v1/order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public String createOrder(@RequestBody OrderSaveDTO orderSaveDTO) throws MQClientException {
        log.info("接收到订单数据:{}", orderSaveDTO.getName());
        orderService.createOrder(orderSaveDTO);
        return "success";
    }

}