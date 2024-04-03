package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Season;
import pl.liga.infrastructure.database.entity.SeasonEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeasonEntityMapper {

    Season mapFromEntity(SeasonEntity entity);

    SeasonEntity mapToEntity(Season season);
}
