package pl.liga.api.dto;

import lombok.*;

import java.util.List;

@Data
@With
@EqualsAndHashCode(of = {"name"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeasonResultsDTO {

    private String name;
    private List<TournamentWithoutAchievementsMatchesDTO> tournaments;
    private List<PlayerSummaryDTO> playerSummaries;
}
