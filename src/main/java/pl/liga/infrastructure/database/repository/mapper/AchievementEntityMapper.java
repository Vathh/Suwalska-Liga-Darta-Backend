package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Achievement;
import pl.liga.infrastructure.database.entity.AchievementEntity;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AchievementEntityMapper {

    Achievement mapFromEntity(AchievementEntity entity);

    AchievementEntity mapToEntity(Achievement achievement);
}
