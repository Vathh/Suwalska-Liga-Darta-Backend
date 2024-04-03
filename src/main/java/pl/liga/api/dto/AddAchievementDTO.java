package pl.liga.api.dto;

import lombok.*;

@Data
@With
@EqualsAndHashCode(of = {"achievementId", "playerId", "type", "value"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddAchievementDTO {

    Integer achievementId;
    Integer playerId;
    Integer tournamentId;
    String type;
    Integer value;
}
