package pl.liga.api.dto;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(of = {"max", "oneSeventy", "hf", "qf"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MatchAchievementsDTO {

    List<AddAchievementDTO> max;
    List<AddAchievementDTO> oneSeventy;
    List<AddAchievementDTO> hf;
    List<AddAchievementDTO> qf;
}
