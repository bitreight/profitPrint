package com.bitreight.profitprint.service.mapper;

import com.bitreight.profitprint.repository.model.ExecutorEntity;
import com.bitreight.profitprint.rest.model.Executor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author bitreight
 */
@Mapper(componentModel = "spring",
        uses = { TimeToLocalTimeMapper.class, LocalTimeToTimeMapper.class },
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExecutorMapper {

    ExecutorEntity toExecutorEntity(Executor executor);
    Executor toExecutor(ExecutorEntity executorEntity);
    List<Executor> toExecutors(List<ExecutorEntity> executorEntities);
}
