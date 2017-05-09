package com.bitreight.profitprint.repository;

import com.bitreight.profitprint.repository.model.RegisterKeyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author bitreight
 */
@Repository
public interface RegisterKeyRepository extends CrudRepository<RegisterKeyEntity, Long> {

    @Query(value = "From RegisterKeyEntity Where value like :value and ExecutorId is null")
    RegisterKeyEntity findUnusedKeyByValue(@Param("value") String value);
}
