package com.bitreight.profitprint.repository;

import com.bitreight.profitprint.repository.model.UserCredentialsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bitreight
 */
@Repository
public interface UserCredentialsRepository extends CrudRepository<UserCredentialsEntity, Integer> {

    UserCredentialsEntity findOneByLogin(String login);
}
