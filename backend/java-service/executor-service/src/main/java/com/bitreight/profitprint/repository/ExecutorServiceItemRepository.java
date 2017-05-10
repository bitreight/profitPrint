package com.bitreight.profitprint.repository;

import com.bitreight.profitprint.repository.model.ExecutorServiceItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bitreight
 */
@Repository
public interface ExecutorServiceItemRepository extends CrudRepository<ExecutorServiceItemEntity, Long> {
}
