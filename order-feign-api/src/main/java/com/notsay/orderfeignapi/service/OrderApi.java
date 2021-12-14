package com.notsay.orderfeignapi.service;

import com.notsay.orderfeignapi.service.vo.OrderTestVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/6 15:43
 */
@FeignClient(name = "service-order", path = "/api/v1/test")
public interface OrderApi {
    @RequestMapping("/test1")
    public String test1();

    @RequestMapping("/test2")
    public OrderTestVO test2();
}