package pl.liga.domain;

import lombok.*;

import java.util.Date;
@Value
@Builder
@With
@EqualsAndHashCode(of = "tournamentId")
@ToString(of = "date")
public class Tournament {

    Integer tournamentId;
    Date date;
    Boolean closed;
    Season season;
}
