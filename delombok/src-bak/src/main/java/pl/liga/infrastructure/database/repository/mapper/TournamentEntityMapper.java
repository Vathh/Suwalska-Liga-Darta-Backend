package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TournamentEntityMapper {

    Tournament mapFromEntity(TournamentEntity entity);

    TournamentEntity mapToEntity(Tournament tournament);
}
