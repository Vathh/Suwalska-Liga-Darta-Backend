package pl.liga.api.dto;

import lombok.*;

import java.util.Date;

@Data
@With
@EqualsAndHashCode(of = {"tournamentId", "date"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TournamentWithoutAchievementsResultsMatchesDTO {

    private Integer tournamentId;
    private Date date;
    private Integer size;
    private Boolean active;
    private Boolean closed;
    private String seasonName;
}
