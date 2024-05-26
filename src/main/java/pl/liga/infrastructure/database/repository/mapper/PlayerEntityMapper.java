package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.*;
import org.springframework.context.annotation.Lazy;
import pl.liga.domain.Achievement;
import pl.liga.domain.Player;
import pl.liga.domain.Result;
import pl.liga.infrastructure.database.entity.AchievementEntity;
import pl.liga.infrastructure.database.entity.PlayerEntity;
import pl.liga.infrastructure.database.entity.ResultEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CycleAvoidingMappingContext.class, ResultEntityMapper.class, AchievementEntityMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerEntityMapper {

    @Qualifiers.WithoutResultsAndAchievements
    @Mappings({
            @Mapping(target = "results", ignore = true),
            @Mapping(target = "achievements", ignore = true)
    })
    Player mapFromEntityWithoutResultsAndAchievements(PlayerEntity entity);

    @Qualifiers.WithoutPlayerAndTournament
    @Mappings({
            @Mapping(target = "achievements", qualifiedBy = Qualifiers.WithoutPlayerAndTournament.class),
            @Mapping(target = "results", qualifiedBy = Qualifiers.WithoutPlayerAndTournament.class)
    })
    Player mapFromEntityWithoutPlayerAndTournament(PlayerEntity entity);

    @Qualifiers.WithoutResultsAndAchievements
    @Mappings({
            @Mapping(target = "results", ignore = true),
            @Mapping(target = "achievements", ignore = true)
    })
    PlayerEntity mapToEntityWithoutResultsAndAchievements(Player player);

    @IterableMapping(qualifiedBy = Qualifiers.WithoutPlayerAndTournament.class)
    List<Achievement> mapAchievementsWithoutPlayerAndTournament(List<AchievementEntity> achievements);

    @IterableMapping(qualifiedBy = Qualifiers.WithoutPlayerAndTournament.class)
    List<Result> mapResultsWithoutPlayerAndTournament(List<ResultEntity> results);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "achievements", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "results", qualifiedBy = Qualifiers.Full.class)
    })
    PlayerEntity mapToEntity(Player player);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "achievements", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "results", qualifiedBy = Qualifiers.Full.class)
    })
    Player mapFromEntity(PlayerEntity entity);
}
