package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = {"resultId", "player", "tournament"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "league_result")
public class ResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private TournamentEntity tournament;

    @Column(name = "points_earned")
    private Integer pointsEarned;
}
