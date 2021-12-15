package com.notsay.user.web.controller;

import com.netflix.discovery.converters.Auto;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/15 16:41
 */
@RestController
@RequestMapping("/api/v1/producer")
public class ProducerController {

    @Resource
    private RocketMQTemplate template;

    @Value("${rocketmq.producer.topic}")
    private String topic;

    @GetMapping("/send")
    public String send(String msg){
        template.convertAndSend(topic,msg);
        return "success";
    }

}