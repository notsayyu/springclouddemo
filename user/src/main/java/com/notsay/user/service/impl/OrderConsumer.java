package com.notsay.user.service.impl;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 16:11
 */
@Component
public class OrderConsumer {
    String consumerGroup = "consumer-group";
    DefaultMQPushConsumer consumer;

    @Autowired
    OrderListener orderListener;

    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr("118.31.59.77:9876");
        consumer.subscribe("order","*");
        consumer.registerMessageListener(orderListener);
        //设置消息重试最大次数
        consumer.setMaxReconsumeTimes(3);
        consumer.start();
    }
}