package com.bitreight.profitprint.repository;

import com.bitreight.profitprint.repository.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bitreight
 */
@Repository
public interface UserRepository<T extends UserEntity> extends CrudRepository<T, Long> {
}
