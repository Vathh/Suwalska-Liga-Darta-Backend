package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.liga.domain.Player;
import pl.liga.domain.Tournament;

@Getter
@Setter
@EqualsAndHashCode(of = {"matchId", "markup", "winner", "loser"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "league_match")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Integer matchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_a_id")
    private PlayerEntity playerA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_b_id")
    private PlayerEntity playerB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id")
    private PlayerEntity winner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loser_id")
    private PlayerEntity loser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private TournamentEntity tournament;

    @Column(name = "markup")
    private String markup;

    @Column(name = "winner_markup")
    private String winnerDestinationMarkup;

    @Column(name = "loser_markup")
    private String loserDestinationMarkup;

    @Column(name = "points")
    private Integer points;

    @Column(name = "match_active")
    private Boolean active;

}
