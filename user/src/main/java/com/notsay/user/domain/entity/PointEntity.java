package com.notsay.user.domain.entity;

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
@Table(name = "point")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointEntity extends BaseEntity{

    @Column(name = "order_name", columnDefinition = "varchar(255) comment '订单名称'")
    private String orderName;

    @Column(name = "integration", columnDefinition = "BIGINT default 0 comment '订单积分'")
    private Long integration;
}