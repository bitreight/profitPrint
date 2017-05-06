package com.bitreight.profitprint.service;

import com.bitreight.profitprint.rest.model.ExecutorToRegister;

/**
 * @author bitreight
 */
public interface ExecutorsRegisterService {

    String createExecutorRegisterKey();

    String registerExecutor(ExecutorToRegister executor);
}
