package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Match;
import pl.liga.infrastructure.database.entity.MatchEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatchEntityMapper {

    Match mapFromEntity(MatchEntity entity);

    MatchEntity mapToEntity(Match match);
}
