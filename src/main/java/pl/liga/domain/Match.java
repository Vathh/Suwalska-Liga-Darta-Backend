package pl.liga.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
@EqualsAndHashCode(of = {"matchId", "markup", "tournament", "winner", "loser"})
public class Match {

    Integer matchId;
    Player playerA;
    Player playerB;
    Player winner;
    Player loser;
    Tournament tournament;
    String markup;
    String winnerDestinationMarkup;
    String loserDestinationMarkup;
    Integer points;
    Boolean active;
}
