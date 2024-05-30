package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Player;
import pl.liga.infrastructure.database.entity.PlayerEntity;

@Mapper(componentModel = "spring", uses = CycleAvoidingMappingContext.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerEntityMapper {

    PlayerEntity mapToEntity(Player player);

    Player mapFromEntity(PlayerEntity entity);
}
