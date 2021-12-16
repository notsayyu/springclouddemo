package com.notsay.user.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author: dsy
 * DateTime: 2021/1/12 13:31
 * Description:  基础repo, 继承2个接口
 */
@NoRepositoryBean
public interface BaseRepo<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
