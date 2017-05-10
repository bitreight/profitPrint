package com.bitreight.profitprint.service.impl;

import com.bitreight.profitprint.repository.ExecutorServiceItemRepository;
import com.bitreight.profitprint.repository.UserRepository;
import com.bitreight.profitprint.repository.model.ExecutorEntity;
import com.bitreight.profitprint.repository.model.ExecutorServiceItemEntity;
import com.bitreight.profitprint.rest.model.ExecutorServiceItem;
import com.bitreight.profitprint.service.ExecutorServiceItemService;
import com.bitreight.profitprint.service.mapper.ExecutorServiceItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bitreight
 */
@Service
public class ExecutorServiceItemServiceImpl implements ExecutorServiceItemService {

    @Autowired
    private ExecutorServiceItemRepository executorServiceItemRepository;
    @Autowired
    private UserRepository<ExecutorEntity> executorRepository;
    @Autowired
    private ExecutorServiceItemMapper executorServiceItemMapper;

    @Override
    public ExecutorServiceItem createExecutorServiceItem(Long executorId, ExecutorServiceItem serviceItem) {
        ExecutorEntity executor = executorRepository.findOneById(executorId);
        if (executor == null) {
            throw new RuntimeException("Executor not found");
        }

        ExecutorServiceItemEntity serviceItemEntity =
                executorServiceItemMapper.toExecutorServiceItemEntity(serviceItem);
        serviceItemEntity.setExecutor(executor);

        ExecutorServiceItemEntity createdServiceItemEntity =
                executorServiceItemRepository.save(serviceItemEntity);

        return executorServiceItemMapper.toExecutorServiceItem(createdServiceItemEntity);
    }

    @Override
    public ExecutorServiceItem getExecutorServiceItemById(Long serviceItemId) {
        return null;
    }

    @Override
    public List<ExecutorServiceItem> getAllExecutorServiceItems(Long executorId) {
        return null;
    }
}
