package com.bitreight.profitprint.repository;

import com.bitreight.profitprint.repository.model.RegisterKeyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bitreight
 */
@Repository
public interface RegisterKeyRepository extends CrudRepository<RegisterKeyEntity, Long> {
}
