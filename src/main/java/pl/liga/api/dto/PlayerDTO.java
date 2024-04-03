package pl.liga.api.dto;

import lombok.*;

import java.util.List;

@Data
@With
@EqualsAndHashCode(of = {"name"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private Integer playerId;
    private String name;
    private Integer hf;
    private Integer qf;
    private Integer max;
    private Integer oneSeventy;
}
