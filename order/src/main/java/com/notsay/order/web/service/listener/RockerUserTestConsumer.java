package com.notsay.order.web.service.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/15 17:00
 */
@Service
@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}", topic = "${rocketmq.consumer.topic}")
public class RockerUserTestConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("从user系统接收到消息:" + s);
    }
}