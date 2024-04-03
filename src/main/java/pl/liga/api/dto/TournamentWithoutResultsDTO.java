package pl.liga.api.dto;

import lombok.*;

import java.util.Date;

@Data
@With
@EqualsAndHashCode(of = {"tournamentId", "date"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TournamentWithoutResultsDTO {

    private Integer tournamentId;
    private Date date;
    private Boolean active;
    private Boolean closed;
    private String seasonName;
    private Integer size;
}
