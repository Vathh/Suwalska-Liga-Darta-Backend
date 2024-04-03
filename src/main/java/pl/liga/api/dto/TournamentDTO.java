package pl.liga.api.dto;

import lombok.*;
import pl.liga.domain.Match;

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
    private Boolean active;
    private Boolean closed;
    private Integer size;
}
