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
    Integer tournamentId;
    PlayerWithoutAchievementsDTO playerA;
    PlayerWithoutAchievementsDTO playerB;
    PlayerWithoutAchievementsDTO winner;
    PlayerWithoutAchievementsDTO loser;
    String markup;
    String winnerDestinationMarkup;
    String loserDestinationMarkup;
    Integer points;
    Boolean active;
}
