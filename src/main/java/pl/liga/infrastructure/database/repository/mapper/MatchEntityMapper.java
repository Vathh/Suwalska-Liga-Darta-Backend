package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Match;
import pl.liga.domain.Player;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.MatchEntity;
import pl.liga.infrastructure.database.entity.PlayerEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatchEntityMapper {

    Match mapFromEntity(MatchEntity entity);

    MatchEntity mapToEntity(Match match);

    @Mappings({
            @Mapping(target = "achievements", ignore = true),
            @Mapping(target = "results", ignore = true)
    })
    Player playerEntityToPlayer(PlayerEntity entity);

    @Mappings({
            @Mapping(target = "results", ignore = true),
            @Mapping(target = "achievements", ignore = true),
            @Mapping(target = "matches", ignore = true),
            @Mapping(target = "season", ignore = true)
    })
    Tournament tournamentEntityToTournament(TournamentEntity entity);
}
