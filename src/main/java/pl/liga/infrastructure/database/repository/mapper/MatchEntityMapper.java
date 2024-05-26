package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Match;
import pl.liga.infrastructure.database.entity.MatchEntity;

@Mapper(componentModel = "spring", uses = { CycleAvoidingMappingContext.class, PlayerEntityMapper.class, TournamentEntityMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatchEntityMapper {

    @Qualifiers.WithoutResultsAndAchievements
    @Mappings({
            @Mapping(target = "playerA", qualifiedBy = Qualifiers.WithoutResultsAndAchievements.class),
            @Mapping(target = "playerB", qualifiedBy = Qualifiers.WithoutResultsAndAchievements.class),
            @Mapping(target = "winner", qualifiedBy = Qualifiers.WithoutResultsAndAchievements.class),
            @Mapping(target = "loser", qualifiedBy = Qualifiers.WithoutResultsAndAchievements.class),
            @Mapping(target = "tournament", qualifiedBy = Qualifiers.IdOnly.class)
    })
    Match mapFromEntityWithoutResultsAndAchievementsWithTournamentId(MatchEntity entity);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "playerA", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "playerB", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "winner", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "loser", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "tournament", qualifiedBy = Qualifiers.Full.class)
    })
    Match mapFromEntity(MatchEntity entity);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "playerA", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "playerB", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "winner", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "loser", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "tournament", qualifiedBy = Qualifiers.Full.class)
    })
    MatchEntity mapToEntity(Match match);
}
