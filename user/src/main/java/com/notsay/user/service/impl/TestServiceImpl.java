package com.notsay.user.service.impl;

import com.notsay.user.domain.entity.order.OrderEntity;
import com.notsay.user.domain.entity.users.UsersEntity;
import com.notsay.user.domain.repo.order.OrderRepo;
import com.notsay.user.domain.repo.users.UsersRepo;
import com.notsay.user.service.TestService;
import javafx.scene.control.TableRow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/22 17:34
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    OrderRepo orderRepo;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void datasource() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setNumber("order001");
        orderRepo.save(orderEntity);

        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUsername("小明");
        int a = 1 / 0;
        usersRepo.save(usersEntity);
    }
}