package pl.liga.api.dto;

import lombok.*;

@Data
@With
@EqualsAndHashCode(of = {"playerName", "pointsEarned"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {

    private Integer pointsEarned;
    private String playerName;
}
