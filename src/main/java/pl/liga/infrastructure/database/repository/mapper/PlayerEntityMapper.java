package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.*;
import pl.liga.domain.Player;
import pl.liga.infrastructure.database.entity.PlayerEntity;

@Mapper(componentModel = "spring", uses = {CycleAvoidingMappingContext.class, AchievementEntityMapper.class, ResultEntityMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerEntityMapper {

    Player mapFromEntity(PlayerEntity entity);

    PlayerEntity mapToEntity(Player player);

    @Named("withoutAchievementsAndResults")
    @Mapping(target = "achievements", ignore = true)
    @Mapping(target = "results", ignore = true)
    Player mapFromEntityWithoutAchievementsAndResults(PlayerEntity entity);
}
