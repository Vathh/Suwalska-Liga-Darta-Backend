package pl.liga.api.dto;

import lombok.*;

@Data
@EqualsAndHashCode(of = {"matchAchievementsDTO", "updateMatchDTO"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MatchResultDTO {

    MatchAchievementsDTO matchAchievementsDTO;
    UpdateMatchDTO updateMatchDTO;
}
