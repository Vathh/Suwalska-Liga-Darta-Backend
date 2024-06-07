package pl.liga.api.dto;

import lombok.*;

@Data
@With
@EqualsAndHashCode(of = {"playerName", "pointsEarned"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {

    private String playerName;
    private Integer pointsEarned;
}
