package pl.liga.domain;

import lombok.*;

@Value
@Builder
@With
@EqualsAndHashCode(of = "playerId")
@ToString(of = {"playerId", "name"})
public class Player {

    Integer playerId;
    String name;
    Integer total;
    Integer participation;
}
