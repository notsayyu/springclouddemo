package com.notsay.user.domain.entity.users;

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
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity extends BaseEntity {

    @Column(name = "username", columnDefinition = "varchar(255) comment '姓名'")
    private String username;
}