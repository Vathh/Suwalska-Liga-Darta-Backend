package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "tournamentId")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "league_tournament")
public class TournamentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Integer tournamentId;
    
    @Column(name = "tournament_date")
    private Date date;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament")
    private Set<ResultEntity> results;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament")
    private Set<AchievementEntity> achievements;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament")
    private Set<MatchEntity> matches;

    @Column(name = "closed")
    private Boolean closed;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private SeasonEntity season;
}
