package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.*;
import pl.liga.domain.Match;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.MatchEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CycleAvoidingMappingContext.class, ResultEntityMapper.class, AchievementEntityMapper.class, MatchEntityMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TournamentEntityMapper {

    @Mapping(target = "matches", source = "matches", qualifiedByName = "withoutAchievementsAndResults")
    Tournament mapFromEntity(TournamentEntity entity);

    TournamentEntity mapToEntity(Tournament tournament);
}
