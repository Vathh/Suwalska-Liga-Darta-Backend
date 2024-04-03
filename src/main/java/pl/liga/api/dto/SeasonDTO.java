package pl.liga.api.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@With
@EqualsAndHashCode(of = {"name", "startDate", "endDate"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDTO {

    private Integer seasonId;
    private String name;
    private Date startDate;
    private Date endDate;
    private Boolean toDelete;
    private List<Date> tournamentFridays;
    private Integer rankCount;
}
