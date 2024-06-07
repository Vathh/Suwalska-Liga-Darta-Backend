package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.*;
import pl.liga.domain.*;
import pl.liga.infrastructure.database.entity.*;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TournamentEntityMapper {

    @Mappings({
            @Mapping(target = "results", ignore = true),
            @Mapping(target = "achievements", ignore = true),
            @Mapping(target = "matches", ignore = true)
    })
    Tournament mapFromEntityWithoutResultsAchievementsMatches(TournamentEntity entity);

    @Mappings({
            @Mapping(target = "results", ignore = true),
            @Mapping(target = "achievements", ignore = true)
    })
    Tournament mapFromEntityWithoutResultsAchievements(TournamentEntity entity);

    @Mapping(target = "matches", ignore = true)
    Tournament mapFromEntityWithoutMatches(TournamentEntity entity);

    Tournament mapFromEntity(TournamentEntity entity);

    TournamentEntity mapToEntity(Tournament tournament);

    @Mapping(target = "tournaments", ignore = true)
    Season seasonEntityToSeason(SeasonEntity entity);

    @Mapping(target = "tournament", ignore = true)
    Result resultEntityToResult(ResultEntity entity);

    @Mapping(target = "tournament", ignore = true)
    Achievement achievementEntityToAchievement(AchievementEntity entity);

    @Mapping(target = "tournament", qualifiedByName = "IdOnly")
    Match matchEntityToMatch(MatchEntity entity);

    @Named("IdOnly")
    @Mappings({
            @Mapping(target = "date", ignore = true),
            @Mapping(target = "results", ignore = true),
            @Mapping(target = "achievements", ignore = true),
            @Mapping(target = "matches", ignore = true),
            @Mapping(target = "size", ignore = true),
            @Mapping(target = "active", ignore = true),
            @Mapping(target = "closed", ignore = true),
            @Mapping(target = "season", ignore = true),
    })
    Tournament mapFromEntityIdOnly(TournamentEntity entity);

    @Mappings({
            @Mapping(target = "achievements", ignore = true),
            @Mapping(target = "results", ignore = true)
    })
    Player playerEntityToPlayer(PlayerEntity entity);
}
