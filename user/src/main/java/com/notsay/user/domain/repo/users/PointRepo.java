package com.notsay.user.domain.repo.users;

import com.notsay.user.domain.entity.users.PointEntity;
import com.notsay.user.domain.repo.BaseRepo;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/16 16:03
 */
@Repository
public interface PointRepo extends BaseRepo<PointEntity, Integer> {

    long countAllByOrderName(String orderName);
}