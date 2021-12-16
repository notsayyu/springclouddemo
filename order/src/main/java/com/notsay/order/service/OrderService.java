package com.notsay.order.service;

import com.notsay.order.domain.dto.OrderSaveDTO;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 14:11
 */
public interface OrderService {

    int saveOrder(OrderSaveDTO orderSaveDTO, String transactionId);

    void createOrder(OrderSaveDTO orderSaveDTO) throws MQClientException;

}