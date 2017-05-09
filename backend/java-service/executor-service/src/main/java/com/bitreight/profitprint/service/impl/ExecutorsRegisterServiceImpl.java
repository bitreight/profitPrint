package com.bitreight.profitprint.service.impl;

import com.bitreight.profitprint.repository.RegisterKeyRepository;
import com.bitreight.profitprint.repository.UserCredentialsRepository;
import com.bitreight.profitprint.repository.model.RegisterKeyEntity;
import com.bitreight.profitprint.repository.model.UserCredentialsEntity;
import com.bitreight.profitprint.repository.model.UserRole;
import com.bitreight.profitprint.rest.model.Executor;
import com.bitreight.profitprint.repository.UserRepository;
import com.bitreight.profitprint.repository.model.ExecutorEntity;
import com.bitreight.profitprint.service.ExecutorsRegisterService;
import com.bitreight.profitprint.service.mapper.ExecutorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author bitreight
 */
@Service
public class ExecutorsRegisterServiceImpl implements ExecutorsRegisterService {

    @Autowired
    private RegisterKeyRepository registerKeyRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    private ExecutorMapper executorMapper;

    @Override
    public String createExecutorRegisterKey() {
        RegisterKeyEntity regKey = new RegisterKeyEntity();
        regKey.setValue(UUID.randomUUID().toString());
        return registerKeyRepository.save(regKey).getValue();
    }

    @Override
    public Executor registerExecutor(Executor executorData) {
        RegisterKeyEntity registerKey = registerKeyRepository.findUnusedKeyByValue(executorData.getRegKey());
        if (registerKey == null) {
            throw new RuntimeException("Register key is used or not found.");
        }

        ExecutorEntity executorToCreate = executorMapper.toExecutorEntity(executorData);

        UserCredentialsEntity executorCredentials = new UserCredentialsEntity();
        executorCredentials.setLogin(executorData.getLogin());
        executorCredentials.setPassword(executorData.getPassword());
        executorCredentials.setUserRole(UserRole.ROLE_EXECUTOR);
        executorCredentials.setUser(executorToCreate);

        ExecutorEntity createdExecutor =
                (ExecutorEntity) userCredentialsRepository.save(executorCredentials).getUser();

        registerKey.setExecutor(createdExecutor);
        registerKeyRepository.save(registerKey);

        return executorMapper.toExecutor(createdExecutor);
    }
}
