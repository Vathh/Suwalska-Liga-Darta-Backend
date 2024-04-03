package pl.liga.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

import java.util.Date;
import java.util.List;

@Value
@Builder
@With
@EqualsAndHashCode(of = "seasonId")
public class Season {

    Integer seasonId;
    String name;
    Date startDate;
    Date endDate;
    List<Tournament> tournaments;
}
