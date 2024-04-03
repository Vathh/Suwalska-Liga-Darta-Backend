package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Season;
import pl.liga.infrastructure.database.entity.SeasonEntity;

@Mapper(componentModel = "spring", uses = {CycleAvoidingMappingContext.class, TournamentEntityMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeasonEntityMapper {
//    , @Context CycleAvoidingMappingContext cycleAvoidingMappingContext

    Season mapFromEntity(SeasonEntity entity);

    SeasonEntity mapToEntity(Season season);

//    @DoIgnore
//    default Season mapFromEntity(SeasonEntity seasonEntity){
//        return mapFromEntity(seasonEntity, new CycleAvoidingMappingContext());
//    }
//
//    @DoIgnore
//    default SeasonEntity mapToEntity(Season season){
//        return mapToEntity(season, new CycleAvoidingMappingContext());
//    }
}
