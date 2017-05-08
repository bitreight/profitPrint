package com.bitreight.profitprint.service.mapper;

import com.bitreight.profitprint.repository.model.ExecutorEntity;
import com.bitreight.profitprint.rest.model.ExecutorToRegister;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author bitreight
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExecutorMapper {

    ExecutorMapper mapper = Mappers.getMapper(ExecutorMapper.class);

    ExecutorEntity toExecutorEntity(ExecutorToRegister executor);
}
