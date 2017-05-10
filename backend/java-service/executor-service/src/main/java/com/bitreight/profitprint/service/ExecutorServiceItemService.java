package com.bitreight.profitprint.service;

import com.bitreight.profitprint.rest.model.ExecutorServiceItem;

import java.util.List;

/**
 * @author bitreight
 */
public interface ExecutorServiceItemService {

    ExecutorServiceItem createExecutorServiceItem(Long executorId, ExecutorServiceItem serviceItem);
    ExecutorServiceItem getExecutorServiceItemById(Long serviceItemId);
    List<ExecutorServiceItem> getAllExecutorServiceItems(Long executorId);
}
