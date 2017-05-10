package com.bitreight.profitprint.rest.executor;

import com.bitreight.profitprint.rest.model.Executor;
import com.bitreight.profitprint.service.ExecutorRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bitreight
 */
@RestController
@RequestMapping("/api/executor")
public class ExecutorRest {

    @Autowired
    private ExecutorRegisterService executorRegisterService;

    @PostMapping("/regkey")
    public String createExecutorRegisterKey() {
        return executorRegisterService.createExecutorRegisterKey();
    }

    @PostMapping
    public Executor registerExecutor(@RequestBody Executor executor) {
        return executorRegisterService.registerExecutor(executor);
    }
}
