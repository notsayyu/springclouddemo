package com.notsay.order.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 13:52
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "transaction_log")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionLogEntity extends BaseEntity{
    @Column(name = "business_tag", columnDefinition = "INT comment '业务类型'")
    private Integer businessTag;

    @Column(name = "foreign_key", columnDefinition = "INT comment '业务外键'")
    private Integer foreignKey;

    @Column(name = "transaction_id", columnDefinition = "varchar(255) comment '事务id'")
    private String transactionId;
}