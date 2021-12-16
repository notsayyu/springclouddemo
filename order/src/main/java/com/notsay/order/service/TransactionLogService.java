package com.notsay.order.service;

import com.notsay.order.domain.dto.TransactionLogSaveDTO;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 14:17
 */
public interface TransactionLogService {

 int save(TransactionLogSaveDTO transactionLogSaveDTO);

 long countLog(String transactionId);
}