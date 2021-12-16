package com.notsay.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.notsay.user.domain.dto.OrderSaveDTO;
import com.notsay.user.service.PointService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 16:15
 */
@Component
@Slf4j
public class OrderListener implements MessageListenerConcurrently {
    @Autowired
    PointService pointService;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        log.info("消费者线程监听到消息");
        try {
            for (MessageExt message:list) {
                log.info("开始处理订单数据，准备增加积分....");
                OrderSaveDTO order  = JSONObject.parseObject(message.getBody(), OrderSaveDTO.class);
                pointService.increasePoints(order);
            }
            log.info("订单数据处理完成");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }catch (Exception e){
            log.error("处理消费者数据发生异常", e);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }
}