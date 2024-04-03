package pl.liga.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
@EqualsAndHashCode(of = "matchId")
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
}
