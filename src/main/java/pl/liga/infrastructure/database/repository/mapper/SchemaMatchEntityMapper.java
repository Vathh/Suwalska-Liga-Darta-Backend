package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.SchemaMatch;
import pl.liga.infrastructure.database.entity.SchemaMatchEntity;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SchemaMatchEntityMapper {

    SchemaMatch mapFromEntity(SchemaMatchEntity entity);
}
