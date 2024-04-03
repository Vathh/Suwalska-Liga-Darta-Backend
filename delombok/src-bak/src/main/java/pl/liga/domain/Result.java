package pl.liga.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
@EqualsAndHashCode(of = "presenceId")
public class Result {

    Integer presenceId;
    Tournament tournament;
    Player player;
    Integer points;
}
