package pl.liga.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.liga.domain.Player;
import pl.liga.infrastructure.database.entity.PlayerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerEntityMapper {

    Player mapFromEntity(PlayerEntity entity);

    PlayerEntity mapToEntity(Player player);
}
