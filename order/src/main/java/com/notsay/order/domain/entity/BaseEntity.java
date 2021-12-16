package com.notsay.order.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.time.Instant;

/**
 * @description:
 * @author: dsy
 * @date: 2020/2/14 13:39
 */
@Data
@MappedSuperclass
@OptimisticLocking
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {

    private static final long serialVersionUID = -1816099275750140714L;

    /**
     * 数据库id, @GeneratedValue中strategy设置为GenerationType.IDENTITY, 使用数据库主键自增策略, 针对MYSQL有效
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 数据库版本信息，Hibernate自动维护,乐观锁
     */
    @Version
    public Integer version;

    @Column(name = "created_at", columnDefinition = "BIGINT COMMENT '创建时间'")
    public Long createdAt;

    @Column(name = "updated_at", columnDefinition = "BIGINT COMMENT '更新时间'")
    public Long updatedAt;

    @Column(name = "deleted", columnDefinition = "BOOLEAN DEFAULT false COMMENT '是否逻辑删除'")
    private boolean deleted;

    @PrePersist
    public void beforeInsert() {
        deleted = false;
        if (version == null) {
            version = 0;
        }
        //在特定场景下, 需要生成自定义创建或记录时间戳的记录, 所以增加null判断, null的时候, 自动创建相关时间戳
        if (createdAt == null) {
            createdAt = Instant.now().toEpochMilli();
        }
        if (updatedAt == null) {
            updatedAt = Instant.now().toEpochMilli();
        }
    }

    @PreUpdate
    public void beforeUpdate() {
        updatedAt = Instant.now().toEpochMilli();
    }
}
