package pl.liga.api.dto;

import lombok.*;

@Data
@With
@EqualsAndHashCode(of = {"tournamentId", "playersIds"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartTournamentDTO {

    private Integer tournamentId;

    private Integer[] playersIds;
}
