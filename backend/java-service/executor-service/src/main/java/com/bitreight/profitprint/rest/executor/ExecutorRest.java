package com.bitreight.profitprint.rest.executor;

import com.bitreight.profitprint.rest.model.Executor;
import com.bitreight.profitprint.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bitreight
 */
@RestController
@RequestMapping("/api/executor")
public class ExecutorRest {

    @Autowired
    private ExecutorService executorService;

    @PostMapping("/regkey")
    public String createExecutorRegisterKey() {
        return executorService.createExecutorRegisterKey();
    }

    @PostMapping
    public Executor registerExecutor(@RequestBody Executor executor) {
        return executorService.registerExecutor(executor);
    }

    @GetMapping("/{executorId}")
    public Executor getExecutorById(@PathVariable("executorId") Long executorId) {
        return executorService.getExecutorById(executorId);
    }

    @GetMapping
    public List<Executor> getAllExecutors() {
        return executorService.getAllExecutors();
    }
}
