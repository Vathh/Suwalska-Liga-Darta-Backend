package pl.liga.infrastructure.database.repository.mapper;

import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Result;
import pl.liga.infrastructure.database.entity.ResultEntity;

@Mapper(componentModel = "spring", uses = { CycleAvoidingMappingContext.class, PlayerEntityMapper.class, TournamentEntityMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResultEntityMapper {

    @Qualifiers.WithoutTournament
    @Mappings({
            @Mapping(target = "player", qualifiedBy = Qualifiers.WithoutResultsAndAchievements.class),
            @Mapping(target = "tournament", ignore = true)
    })
    Result mapFromEntityWithoutTournament(ResultEntity entity);

    @Qualifiers.WithoutPlayerAndTournament
    @Mappings({
            @Mapping(target = "player", ignore = true),
            @Mapping(target = "tournament", ignore = true)
    })
    Result mapFromEntityWithoutPlayerAndTournament(ResultEntity entity);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "player", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "tournament", qualifiedBy = Qualifiers.Full.class)
    })
    Result mapFromEntity(ResultEntity entity);

    @Qualifiers.Full
    @Mappings({
            @Mapping(target = "player", qualifiedBy = Qualifiers.Full.class),
            @Mapping(target = "tournament", qualifiedBy = Qualifiers.Full.class)
    })
    ResultEntity mapToEntity(Result result);
}
