package pl.liga.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
@EqualsAndHashCode(of = {"achievementId", "player", "type", "value"})
public class Achievement {

    Integer achievementId;
    Player player;
    Tournament tournament;
    String type;
    Integer value;
}
