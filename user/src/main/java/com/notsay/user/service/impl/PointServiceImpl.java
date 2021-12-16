package com.notsay.user.service.impl;

import com.notsay.user.domain.dto.OrderSaveDTO;
import com.notsay.user.domain.entity.PointEntity;
import com.notsay.user.domain.repo.PointRepo;
import com.notsay.user.service.PointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 16:18
 */
@Service
@Slf4j
public class PointServiceImpl implements PointService {
    @Autowired
    PointRepo pointRepo;

    @Override
    public void increasePoints(OrderSaveDTO orderSaveDTO) {
        if (pointRepo.countAllByOrderName(orderSaveDTO.getName()) > 0) {
            log.info("该订单已处理");
        }else {
            PointEntity pointEntity = new PointEntity();
            pointEntity.setOrderName(orderSaveDTO.getName());
            pointEntity.setIntegration(1L);
            pointRepo.save(pointEntity);
        }
    }
}