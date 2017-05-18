package com.bitreight.profitprint.repository;

import com.bitreight.profitprint.repository.model.ExecutorEntity;
import com.bitreight.profitprint.repository.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bitreight
 */
@Repository
public interface ExecutorRepository extends CrudRepository<ExecutorEntity, Long> {
}
