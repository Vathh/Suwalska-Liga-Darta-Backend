package pl.liga.api.dto;

import lombok.*;

@Data
@With
@EqualsAndHashCode(of = {"achievementId", "playerName", "type", "value"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AchievementDTO {

    Integer achievementId;
    String playerName;
    String type;
    Integer value;
}
