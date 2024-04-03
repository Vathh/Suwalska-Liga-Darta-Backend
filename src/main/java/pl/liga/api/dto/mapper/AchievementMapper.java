package pl.liga.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.liga.api.dto.AchievementDTO;
import pl.liga.api.dto.AddAchievementDTO;
import pl.liga.domain.Achievement;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    default AchievementDTO map(final Achievement achievement){
        return AchievementDTO.builder()
                .achievementId(achievement.getAchievementId())
                .playerName(achievement.getPlayer().getName())
                .type(achievement.getType())
                .value(achievement.getValue())
                .build();
    }
}
