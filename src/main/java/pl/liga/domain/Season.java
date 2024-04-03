package pl.liga.domain;

import lombok.*;

import java.util.Date;
import java.util.List;

@ToString
@Getter
@Builder
@With
@EqualsAndHashCode(of = {"seasonId", "name", "startDate"})
public final class Season {

    private final Integer seasonId;
    private final String name;
    private final Date startDate;
    private final Date endDate;
    private final Boolean toDelete;
    private final List<Tournament> tournaments;
    private final Integer rankCount;
}
