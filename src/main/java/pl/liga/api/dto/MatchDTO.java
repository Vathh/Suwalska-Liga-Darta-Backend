package pl.liga.api.dto;

import lombok.*;

@Data
@With
@EqualsAndHashCode(of = {"matchId", "markup"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MatchDTO {

    Integer matchId;
    PlayerWithoutAchievementsResultsDTO playerA;
    PlayerWithoutAchievementsResultsDTO playerB;
    PlayerWithoutAchievementsResultsDTO winner;
    PlayerWithoutAchievementsResultsDTO loser;
    Integer tournamentId;
    String markup;
    String winnerDestinationMarkup;
    String loserDestinationMarkup;
    Integer points;
    Boolean active;
}
