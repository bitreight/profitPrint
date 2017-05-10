package com.bitreight.profitprint.service;

import com.bitreight.profitprint.rest.model.Executor;

/**
 * @author bitreight
 */
public interface ExecutorRegisterService {

    String createExecutorRegisterKey();
    Executor registerExecutor(Executor executor);
}
