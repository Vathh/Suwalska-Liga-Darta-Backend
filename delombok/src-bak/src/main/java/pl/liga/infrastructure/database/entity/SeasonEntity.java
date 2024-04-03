package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "seasonId")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "league_season")
public class SeasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id")
    private Integer seasonId;

    @Column(name = "season_name")
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "season", cascade = CascadeType.ALL)
    private Set<TournamentEntity> tournaments;
}
