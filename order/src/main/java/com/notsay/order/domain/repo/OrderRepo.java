package com.notsay.order.domain.repo;

import com.notsay.order.domain.entity.OrderEntity;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 13:50
 */
@Repository
public interface OrderRepo extends BaseRepo<OrderEntity, Integer>{
}