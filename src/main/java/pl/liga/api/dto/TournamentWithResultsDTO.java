package pl.liga.api.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@With
@EqualsAndHashCode(of = {"tournamentId", "date"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TournamentWithResultsDTO {

    private Integer tournamentId;
    private Date date;
    private Boolean active;
    private Boolean closed;
    private List<ResultDTO> results;
    private Integer size;
}
