package com.notsay.order.service.impl;

import com.notsay.order.domain.dto.TransactionLogSaveDTO;
import com.notsay.order.domain.entity.TransactionLogEntity;
import com.notsay.order.domain.repo.TransactionLogRepo;
import com.notsay.order.service.TransactionLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 14:18
 */
@Service
@Slf4j
public class TransactionLogServiceImpl implements TransactionLogService {
    @Autowired
    TransactionLogRepo transactionLogRepo;

    @Override
    public int save(TransactionLogSaveDTO transactionLogSaveDTO) {
        TransactionLogEntity transactionLogEntity = new TransactionLogEntity();
        transactionLogEntity.setBusinessTag(transactionLogSaveDTO.getBusinessTag());
        transactionLogEntity.setForeignKey(transactionLogSaveDTO.getForeignKey());
        transactionLogEntity.setTransactionId(transactionLogSaveDTO.getTransactionId());
        transactionLogRepo.save(transactionLogEntity);

        return transactionLogEntity.getId();
    }

    @Override
    public long countLog(String transactionId) {
        long count = transactionLogRepo.countAllByTransactionId(transactionId);
        return count;
    }
}