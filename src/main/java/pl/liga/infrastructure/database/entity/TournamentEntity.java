package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"tournamentId", "date", "active", "closed"})
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
    private List<ResultEntity> results;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament")
    private List<AchievementEntity> achievements;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<MatchEntity> matches;

    @Column(name = "tournament_size")
    private Integer size;

    @Column(name = "tournament_active")
    private Boolean active;

    @Column(name = "closed")
    private Boolean closed;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private SeasonEntity season;

    public TournamentEntity(Integer tournamentId, Date date, Boolean closed){
        this.tournamentId = tournamentId;
        this.date = date;
        this.closed = closed;
    }
}
