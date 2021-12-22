package com.notsay.user.domain.repo.order;

import com.notsay.user.domain.entity.order.OrderEntity;
import com.notsay.user.domain.entity.users.UsersEntity;
import com.notsay.user.domain.repo.BaseRepo;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 16:03
 */
@Repository
public interface OrderRepo extends BaseRepo<OrderEntity, Integer> {
    
}