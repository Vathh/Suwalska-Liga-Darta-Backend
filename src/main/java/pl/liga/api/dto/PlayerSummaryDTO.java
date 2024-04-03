package pl.liga.api.dto;

import lombok.*;

@Data
@With
@Setter
@EqualsAndHashCode(of = {"name"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerSummaryDTO {

    private String name;
    private Integer rank;
    private Integer total;
    private Integer frequency;
    private Integer max;
    private Integer oneSeventy;
    private Integer hf;
    private Integer qf;
}
