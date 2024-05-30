package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Season;
import pl.liga.infrastructure.database.entity.SeasonEntity;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeasonEntityMapper {
    Season mapFromEntity(SeasonEntity entity);

    SeasonEntity mapToEntity(Season season);
}
