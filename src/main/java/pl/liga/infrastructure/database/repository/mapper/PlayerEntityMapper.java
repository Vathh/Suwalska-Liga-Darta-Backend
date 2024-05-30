package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Achievement;
import pl.liga.domain.Player;
import pl.liga.domain.Result;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.AchievementEntity;
import pl.liga.infrastructure.database.entity.PlayerEntity;
import pl.liga.infrastructure.database.entity.ResultEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerEntityMapper {

    PlayerEntity mapToEntity(Player player);

    Player mapFromEntity(PlayerEntity entity);

    @Mappings({
            @Mapping(target = "achievements", ignore = true),
            @Mapping(target = "results", ignore = true)
    })
    Player mapFromEntityWithoutAchievementsAndResults(PlayerEntity entity);

    @Mapping(target = "player", ignore = true)
    Achievement achievementEntityToAchievement(AchievementEntity entity);

    @Mapping(target = "player", ignore = true)
    Result resultEntityToResult(ResultEntity entity);

    @Mappings({
            @Mapping(target = "results", ignore = true),
            @Mapping(target = "achievements", ignore = true),
            @Mapping(target = "matches", ignore = true),
            @Mapping(target = "season", ignore = true)
    })
    Tournament tournamentEntityToTournament(TournamentEntity entity);
}
