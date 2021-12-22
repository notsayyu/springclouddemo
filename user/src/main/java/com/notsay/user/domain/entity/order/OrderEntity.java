package com.notsay.user.domain.entity.order;

import com.notsay.user.domain.entity.BaseEntity;
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
public class OrderEntity extends BaseEntity {

    @Column(name = "number", columnDefinition = "varchar(255) comment '编号'")
    private String number;
}