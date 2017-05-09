package com.bitreight.profitprint.service.impl;

import com.bitreight.profitprint.repository.RegisterKeyRepository;
import com.bitreight.profitprint.repository.model.RegisterKeyEntity;
import com.bitreight.profitprint.rest.model.Executor;
import com.bitreight.profitprint.repository.UserRepository;
import com.bitreight.profitprint.repository.model.ExecutorEntity;
import com.bitreight.profitprint.service.ExecutorsRegisterService;
import com.bitreight.profitprint.service.mapper.ExecutorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author bitreight
 */
@Service
public class ExecutorsRegisterServiceImpl implements ExecutorsRegisterService {

    @Autowired
    private RegisterKeyRepository registerKeyRepository;

    @Autowired
    private UserRepository<ExecutorEntity> executorRepository;

    @Autowired
    private ExecutorMapper executorMapper;

    @Override
    public String createExecutorRegisterKey() {
        RegisterKeyEntity regKey = new RegisterKeyEntity();
        regKey.setValue(UUID.randomUUID().toString());
        return registerKeyRepository.save(regKey).getValue();
    }

    @Override
    public Executor registerExecutor(Executor executor) {
        ExecutorEntity executorEntity = executorMapper.toExecutorEntity(executor);
        Executor executor1 = executorMapper.toExecutor(executorEntity);
        return executor1;
    }
}
