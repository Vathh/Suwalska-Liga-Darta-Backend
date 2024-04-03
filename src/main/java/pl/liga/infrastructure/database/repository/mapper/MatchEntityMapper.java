package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.*;
import pl.liga.domain.Match;
import pl.liga.domain.Player;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.MatchEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CycleAvoidingMappingContext.class, PlayerEntityMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatchEntityMapper {

    @Named("FullMatch")
    Match mapFromEntity(MatchEntity entity);

    @Named("withoutAchievementsAndResults")
    @Mapping(target = "playerA", source = "playerA", qualifiedByName = "withoutAchievementsAndResults")
    @Mapping(target = "playerB", source = "playerB", qualifiedByName = "withoutAchievementsAndResults")
    @Mapping(target = "winner", qualifiedByName = "withoutAchievementsAndResults")
    @Mapping(target = "loser", qualifiedByName = "withoutAchievementsAndResults")
    Match mapFromEntityWithoutAchievementsAndResults(MatchEntity entity);

    MatchEntity mapToEntity(Match match);
}
