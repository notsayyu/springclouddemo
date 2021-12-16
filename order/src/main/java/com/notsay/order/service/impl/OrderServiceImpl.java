package com.notsay.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.notsay.order.domain.dto.OrderSaveDTO;
import com.notsay.order.domain.dto.TransactionLogSaveDTO;
import com.notsay.order.domain.entity.OrderEntity;
import com.notsay.order.domain.repo.OrderRepo;
import com.notsay.order.service.OrderService;
import com.notsay.order.service.TransactionLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 14:11
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    TransactionLogService transactionLogService;

    @Autowired
    TransactionProducer producer;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveOrder(OrderSaveDTO orderSaveDTO, String transactionId) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderName(orderSaveDTO.getName());
        orderEntity.setContent(orderSaveDTO.getContent());
        orderRepo.save(orderEntity);

        //插入order成功之后插入事务日志
        TransactionLogSaveDTO transactionLogSaveDTO = new TransactionLogSaveDTO();
        //1--order
        transactionLogSaveDTO.setBusinessTag(1);
        transactionLogSaveDTO.setForeignKey(orderEntity.getId());
        transactionLogSaveDTO.setTransactionId(transactionId);
        transactionLogService.save(transactionLogSaveDTO);
        log.info("创建订单完成");
        return orderEntity.getId();
    }

    @Override
    public void createOrder(OrderSaveDTO orderSaveDTO) throws MQClientException {
        producer.send(JSON.toJSONString(orderSaveDTO), "order");
    }
}