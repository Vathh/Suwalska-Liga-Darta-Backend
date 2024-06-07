package pl.liga.api.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@With
@EqualsAndHashCode(of = {"tournamentId", "date"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TournamentWithoutMatchesDTO {

    private Integer tournamentId;
    private Date date;
    private List<ResultDTO> results;
    private List<AchievementDTO> achievements;
    private Integer size;
    private Boolean active;
    private Boolean closed;
}
