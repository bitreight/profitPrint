package com.bitreight.profitprint.rest.executor;

import com.bitreight.profitprint.rest.model.ExecutorToRegister;
import com.bitreight.profitprint.service.ExecutorsRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bitreight
 */
@RestController
public class ExecutorsRest {

    @Autowired
    private ExecutorsRegisterService executorsRegisterService;

    @PostMapping("/api/executors/regkeys")
    public String createNewExecutor() {
        return executorsRegisterService.createExecutorRegisterKey();
    }

    @PostMapping("/api/executors")
    public void registerExecutor(ExecutorToRegister executor) {

    }
}
