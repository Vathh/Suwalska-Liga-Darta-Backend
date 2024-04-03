package pl.liga.api.dto;

import lombok.*;

@Data
@With
@EqualsAndHashCode(of = {"name"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerWithoutAchievementsDTO {

    private Integer playerId;
    private String name;
}
