package com.notsay.user.service;

import com.notsay.user.domain.dto.OrderSaveDTO;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 16:17
 */
public interface PointService {

    void increasePoints(OrderSaveDTO orderSaveDTO);
}