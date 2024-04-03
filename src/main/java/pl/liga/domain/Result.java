package pl.liga.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
@EqualsAndHashCode(of = {"resultId", "player", "pointsEarned"})
public class Result {

    Integer resultId;
    Player player;
    Tournament tournament;
    Integer pointsEarned;
}
