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
@Getter
public class TournamentDTO {

    private Integer tournamentId;
    private Date date;
    private List<MatchDTO> matches;
    private Integer size;
    private Boolean active;
    private Boolean closed;
}
