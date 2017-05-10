package com.bitreight.profitprint.service.mapper;

import com.bitreight.profitprint.repository.model.ExecutorServiceItemEntity;
import com.bitreight.profitprint.rest.model.ExecutorServiceItem;
import org.mapstruct.Mapper;

/**
 * @author bitreight
 */
@Mapper(componentModel = "spring")
public interface ExecutorServiceItemMapper {

    ExecutorServiceItemEntity toExecutorServiceItemEntity(ExecutorServiceItem serviceItem);
    ExecutorServiceItem toExecutorServiceItem(ExecutorServiceItemEntity serviceItemEntity);
}
