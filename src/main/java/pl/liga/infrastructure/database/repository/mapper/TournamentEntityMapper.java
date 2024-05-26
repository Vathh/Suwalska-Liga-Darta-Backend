package pl.liga.infrastructure.database.repository.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.*;
import org.springframework.stereotype.Component;
import pl.liga.domain.Achievement;
import pl.liga.domain.Result;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.AchievementEntity;
import pl.liga.infrastructure.database.entity.ResultEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CycleAvoidingMappingContext.class, ResultEntityMapper.class, AchievementEntityMapper.class, MatchEntityMapper.class, SeasonEntityMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TournamentEntityMapper {

    @Qualifiers.WithoutMatchesAndSeason
    @Mappings({
            @Mapping(target = "matches", ignore = true),
            @Mapping(target = "season", ignore = true),
            @Mapping(target = "results", qualifiedBy = Qualifiers.WithoutTournament.class),
            @Mapping(target = "achievements", qualifiedBy = Qualifiers.WithoutTournament.class)
    })
    Tournament mapFromEntityWithoutMatchesAndSeason(TournamentEntity entity);

    @Qualifiers.WithoutResultsAchievementsAndMatches
    @Mappings({
            @Mapping(target = "results", ignore = true),
            @Mapping(target = "achievements", ignore = true),
            @Mapping(target = "matches", ignore = true),
            @Mapping(target = "season", qualifiedBy = Qualifiers.Full.class)
    })
    TournamentEntity mapToEntityWithoutResultsAchievementsAndMatches(Tournament tournament);

    @Qualifiers.IdOnly
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
    Tournament mapIdOnlyFromEntity(TournamentEntity entity);

    @Qualifiers.IdOnly
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
    TournamentEntity mapIdOnlyFromEntity(Tournament tournament);

    @IterableMapping(qualifiedBy = Qualifiers.WithoutTournament.class)
    List<Result> mapResultsFromEntities(List<ResultEntity> results);

    @IterableMapping(qualifiedBy = Qualifiers.WithoutTournament.class)
    List<Achievement> mapAchievementsFromEntites(List<AchievementEntity> achievements);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "matches", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "season", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "results", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "achievements", qualifiedBy = Qualifiers.Full.class)
    })
    Tournament mapFromEntity(TournamentEntity entity);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "matches", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "season", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "results", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "achievements", qualifiedBy = Qualifiers.Full.class)
    })
    TournamentEntity mapToEntity(Tournament tournament);
}
