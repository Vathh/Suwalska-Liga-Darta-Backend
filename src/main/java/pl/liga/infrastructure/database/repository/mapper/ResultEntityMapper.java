package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Result;
import pl.liga.infrastructure.database.entity.ResultEntity;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResultEntityMapper {
    Result mapFromEntity(ResultEntity entity);

    ResultEntity mapToEntity(Result result);
}
