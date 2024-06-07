package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Player;
import pl.liga.domain.Season;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.PlayerEntity;
import pl.liga.infrastructure.database.entity.SeasonEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeasonEntityMapper {
    Season mapFromEntity(SeasonEntity entity);

    SeasonEntity mapToEntity(Season season);

    @Mappings({
            @Mapping(target = "season", ignore = true),
            @Mapping(target = "matches", ignore = true)
    })
    Tournament tournamentEntityToTournament(TournamentEntity entity);

    @Mappings({
            @Mapping(target = "achievements", ignore = true),
            @Mapping(target = "results", ignore = true)
    })
    Player playerEntityToPlayer(PlayerEntity entity);
}
