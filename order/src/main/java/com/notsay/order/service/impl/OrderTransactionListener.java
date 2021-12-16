package com.notsay.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.notsay.order.domain.dto.OrderSaveDTO;
import com.notsay.order.service.OrderService;
import com.notsay.order.service.TransactionLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 14:10
 */
@Component
@Slf4j
public class OrderTransactionListener implements TransactionListener {
    @Autowired
    OrderService orderService;

    @Autowired
    TransactionLogService transactionLogService;

    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        log.info("半消息发送成功，开始执行本地事务");
        LocalTransactionState state;
        try {
            String body = new String(message.getBody());
            OrderSaveDTO orderSaveDTO = JSONObject.parseObject(body, OrderSaveDTO.class);
            String transactionId = message.getTransactionId();
            int id = orderService.saveOrder(orderSaveDTO, transactionId);
            log.info("创建订单id为:{}", id);
            state = LocalTransactionState.COMMIT_MESSAGE;
            log.info("本地事务已提交:{}", message.getTransactionId());
        }catch (Exception e){
            log.error("执行本地事务失败", e);
            state = LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return state;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        log.info("开始回查本地事务状态:{}", messageExt.getTransactionId());
        LocalTransactionState state;
        String transactionId = messageExt.getTransactionId();
        if(transactionLogService.countLog(transactionId) > 0){
            state = LocalTransactionState.COMMIT_MESSAGE;
        }else {
            state = LocalTransactionState.UNKNOW;
        }
        log.info("结束本地事务查询:{}", state);

        return state;
    }
}