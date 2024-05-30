package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TournamentEntityMapper {

    Tournament mapFromEntity(TournamentEntity entity);

    TournamentEntity mapToEntity(Tournament tournament);
}
