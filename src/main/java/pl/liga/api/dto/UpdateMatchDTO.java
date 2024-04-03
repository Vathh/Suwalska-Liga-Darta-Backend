package pl.liga.api.dto;

import lombok.*;

@Data
@With
@EqualsAndHashCode(of = {"matchId", "winnerId", "loserId"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMatchDTO {

    private Integer tournamentId;
    private Integer matchId;
    private Integer winnerId;
    private Integer loserId;
    private String markup;
    private String winnerDestinationMarkup;
    private String loserDestinationMarkup;
    private Integer points;
}
