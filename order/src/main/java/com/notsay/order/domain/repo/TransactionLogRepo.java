package com.notsay.order.domain.repo;

import com.notsay.order.domain.entity.OrderEntity;
import com.notsay.order.domain.entity.TransactionLogEntity;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 13:50
 */
@Repository
public interface TransactionLogRepo extends BaseRepo<TransactionLogEntity, Integer>{

    long countAllByBusinessTagAndForeignKey(int businessTag, int foreignKey);

    long countAllByTransactionId(String transactionId);
}