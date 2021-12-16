package com.notsay.order.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 13:48
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity{

    @Column(name = "order_name", columnDefinition = "varchar(255) comment '订单名称'")
    private String orderName;

    @Column(name = "content", columnDefinition = "varchar(255) comment '订单内容'")
    private String content;
}