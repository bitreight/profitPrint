package com.bitreight.profitprint.rest.executor;

import com.bitreight.profitprint.rest.model.ExecutorServiceItem;
import com.bitreight.profitprint.service.ExecutorServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bitreight
 */
@RestController
@RequestMapping("/api/executor/{executorId}/service")
public class ExecutorServiceItemRest {

    @Autowired
    private ExecutorServiceItemService executorServiceItemService;

    @PostMapping
    public ExecutorServiceItem createExecutorServiceItem(@PathVariable("executorId") Long executorId,
                                                     @RequestBody ExecutorServiceItem serviceItem) {
        return executorServiceItemService.createExecutorServiceItem(executorId, serviceItem);
    }

    @GetMapping("/{serviceId}")
    public ExecutorServiceItem getExecutorServiceItemById(@PathVariable("executorId") Long executorId,
                                                          @PathVariable("serviceId") Long serviceItemId) {
        return executorServiceItemService.getExecutorServiceItemById(executorId, serviceItemId);
    }

    @GetMapping
    public List<ExecutorServiceItem> getAllExecutorServiceItems(@PathVariable("executorId") Long executorId) {
        return executorServiceItemService.getAllExecutorServiceItems(executorId);
    }

    public ExecutorServiceItem updateExecutorServiceItemId(@PathVariable("executorId") Long executorId,
                                                           @RequestBody ExecutorServiceItem serviceItem) {
        return null;
    }

    public ExecutorServiceItem deleteExecutorServiceItemId(Long executorId) {
        return null;
    }
}
