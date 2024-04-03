package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Result;
import pl.liga.infrastructure.database.entity.ResultEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResultEntityMapper {

    Result mapFromEntity(ResultEntity entity);

    ResultEntity mapToEntity(Result result);
}
