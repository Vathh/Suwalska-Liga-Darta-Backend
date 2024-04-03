package pl.liga.api.dto;

import lombok.*;

import java.util.Date;

@Data
@With
@EqualsAndHashCode(of = {"date", "closed"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TournamentDTO {

    private Integer tournamentId;
    private Date date;
    private Boolean closed;
}
