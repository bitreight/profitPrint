package com.bitreight.profitprint.service.impl;

import com.bitreight.profitprint.repository.ExecutorServiceItemRepository;
import com.bitreight.profitprint.repository.ExecutorRepository;
import com.bitreight.profitprint.repository.model.ExecutorEntity;
import com.bitreight.profitprint.repository.model.ExecutorServiceItemEntity;
import com.bitreight.profitprint.rest.model.ExecutorServiceItem;
import com.bitreight.profitprint.service.ExecutorServiceItemService;
import com.bitreight.profitprint.service.mapper.ExecutorServiceItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author bitreight
 */
@Service
public class ExecutorServiceItemServiceImpl implements ExecutorServiceItemService {

    @Autowired
    private ExecutorServiceItemRepository executorServiceItemRepository;
    @Autowired
    private ExecutorRepository executorRepository;
    @Autowired
    private ExecutorServiceItemMapper executorServiceItemMapper;

    @Override
    public ExecutorServiceItem createExecutorServiceItem(Long executorId, ExecutorServiceItem serviceItem) {
        ExecutorEntity executor = getExecutorOrThrow(executorId);

        ExecutorServiceItemEntity serviceItemEntity =
                executorServiceItemMapper.toExecutorServiceItemEntity(serviceItem);
        serviceItemEntity.setExecutor(executor);

        ExecutorServiceItemEntity createdServiceItemEntity =
                executorServiceItemRepository.save(serviceItemEntity);

        return executorServiceItemMapper.toExecutorServiceItem(createdServiceItemEntity);
    }

    @Override
    public ExecutorServiceItem getExecutorServiceItemById(Long executorId, Long serviceItemId) {
        getExecutorOrThrow(executorId);

        ExecutorServiceItemEntity serviceItemEntity = executorServiceItemRepository.findOne(serviceItemId);
        if (serviceItemEntity == null) {
            throw new RuntimeException("Executor service not found.");
        }

        return executorServiceItemMapper.toExecutorServiceItem(serviceItemEntity);
    }

    @Override
    public List<ExecutorServiceItem> getAllExecutorServiceItems(Long executorId) {
        List<ExecutorServiceItemEntity> serviceItemEntities
                = (List<ExecutorServiceItemEntity>) executorServiceItemRepository.findAll();
        if (serviceItemEntities.isEmpty()) {
            serviceItemEntities = Collections.emptyList();
        }

        return executorServiceItemMapper.toExecutorServiceItems(serviceItemEntities);
    }

    @Override
    public ExecutorServiceItem updateExecutorServiceItemById(Long executorId, ExecutorServiceItem serviceItem) {
        return null;
    }

    @Override
    public ExecutorServiceItem deleteExecutorServiceItemById(Long executorId) {
        return null;
    }

    private ExecutorEntity getExecutorOrThrow(Long executorId) {
        ExecutorEntity executor = executorRepository.findOne(executorId);
        if (executor == null) {
            throw new RuntimeException("Executor not found.");
        }
        return executor;
    }
}
