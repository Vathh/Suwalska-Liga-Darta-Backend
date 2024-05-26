package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Achievement;
import pl.liga.infrastructure.database.entity.AchievementEntity;

//@Mapper(componentModel = "spring", uses = { CycleAvoidingMappingContext.class, PlayerEntityMapper.class, TournamentEntityMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AchievementEntityMapper {

    @Qualifiers.WithoutTournament
    @Mappings({
            @Mapping(target = "tournament", ignore = true),
            @Mapping(target = "player", qualifiedBy = Qualifiers.Full.class)
    })
    Achievement mapFromEntityWithoutTournament(AchievementEntity entity);

    @Qualifiers.WithoutPlayerAndTournament
    @Mappings({
            @Mapping(target = "tournament", ignore = true),
            @Mapping(target = "player", ignore = true)
    })
    Achievement mapFromEntityWithoutPlayerAndTournament(AchievementEntity entity);

    @Qualifiers.WithoutResultsAndAchievements
    @Mappings({
            @Mapping(target = "player", qualifiedBy = Qualifiers.WithoutResultsAndAchievements.class),
            @Mapping(target = "tournament", qualifiedBy = Qualifiers.WithoutResultsAchievementsAndMatches.class)
    })
    AchievementEntity mapToEntityWithoutResultsAndAchievements(Achievement achievement);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "player", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "tournament", qualifiedBy = Qualifiers.Full.class)
    })
    Achievement mapFromEntity(AchievementEntity entity);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "player", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "tournament", qualifiedBy = Qualifiers.Full.class)
    })
    AchievementEntity mapToEntity(Achievement achievement);
}
