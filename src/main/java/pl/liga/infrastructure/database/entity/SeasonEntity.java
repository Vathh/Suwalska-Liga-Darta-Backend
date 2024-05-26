package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"seasonId", "name", "startDate"})
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

    @Column(name = "to_delete")
    private Boolean toDelete;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "season")
    private List<TournamentEntity> tournaments;

    @Column(name = "rank_count")
    private Integer rankCount;
}
