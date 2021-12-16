package com.notsay.order.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionLogSaveDTO {
    private Integer businessTag;

    private Integer foreignKey;

    private String transactionId;
}