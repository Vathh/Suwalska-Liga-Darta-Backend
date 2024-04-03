package pl.liga.domain;

import lombok.*;

import java.util.Date;
import java.util.List;

@Value
@Builder
@With
@EqualsAndHashCode(of = {"tournamentId", "date", "closed"})
@ToString(of = "date")
public class Tournament {

    Integer tournamentId;
    Date date;
    Boolean active;
    Boolean closed;
    List<Result> results;
    List<Achievement> achievements;
    List<Match> matches;
    Integer size;
    Season season;
}
