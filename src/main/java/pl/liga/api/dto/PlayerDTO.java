package pl.liga.api.dto;

import lombok.*;

@Data
@With
@EqualsAndHashCode(of = {"name"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private Integer playerId;
    private String name;
    private Integer max;
    private Integer oneSeventy;
    private Integer hf;
    private Integer qf;
}
