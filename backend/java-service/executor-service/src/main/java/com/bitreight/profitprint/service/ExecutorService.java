package com.bitreight.profitprint.service;

import com.bitreight.profitprint.rest.model.Executor;

import java.util.List;

/**
 * @author bitreight
 */
public interface ExecutorService {

    String createExecutorRegisterKey();
    Executor registerExecutor(Executor executor);
    Executor getExecutorById(Long executorId);
    List<Executor> getAllExecutors();
}
