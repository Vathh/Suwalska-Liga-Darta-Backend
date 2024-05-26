package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.*;
import pl.liga.domain.Season;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.SeasonEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CycleAvoidingMappingContext.class, TournamentEntityMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeasonEntityMapper {

    @Qualifiers.WithoutMatchesAndSeason
    @Mapping(target = "tournaments", qualifiedBy = Qualifiers.WithoutMatchesAndSeason.class)
    Season mapFromEntityWithoutMatchesAndSeason(SeasonEntity entity);

    @Qualifiers.WithoutResultsAchievementsAndMatches
    @Mapping(target = "tournaments", qualifiedBy = Qualifiers.WithoutResultsAchievementsAndMatches.class)
    SeasonEntity mapToEntityWithoutResultsAchievementsAndMatches(Season season);

    @IterableMapping(qualifiedBy = Qualifiers.WithoutMatchesAndSeason.class)
    List<Tournament> mapTournamentsWithoutMatchesAndSeasonFromEntites(List<TournamentEntity> tournaments);

    @IterableMapping(qualifiedBy = Qualifiers.WithoutResultsAchievementsAndMatches.class)
    List<TournamentEntity> mapTournamentsWithoutResultsAchievementsAndMatchesToEntities(List<Tournament> tournaments);

    @IterableMapping(qualifiedBy = Qualifiers.Full.class)
    List<Tournament> mapTournamentsFullFromEntities(List<TournamentEntity> entities);

    @IterableMapping(qualifiedBy = Qualifiers.Full.class)
    List<TournamentEntity> mapTournamentsFullToEntities(List<Tournament> entities);

    @Qualifiers.Full
    @Mapping(target = "tournaments", qualifiedBy = Qualifiers.Full.class)
    Season mapFromEntity(SeasonEntity entity);

    @Qualifiers.Full
    @Mapping(target = "tournaments", qualifiedBy = Qualifiers.Full.class)
    SeasonEntity mapToEntity(Season season);
}
