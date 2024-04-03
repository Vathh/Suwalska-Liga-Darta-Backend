package pl.liga.domain;

import lombok.*;

import java.util.List;

@Value
@Builder
@With
@EqualsAndHashCode(of = {"playerId", "name"})
@ToString(of = {"playerId", "name"})
public class Player {

    Integer playerId;
    String name;
    List<Achievement> achievements;
    List<Result> results;
}
