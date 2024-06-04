package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = {"achievementId", "type", "value", "player"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "league_achievement")
public class AchievementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    private Integer achievementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private TournamentEntity tournament;

    @Column(name = "achievement_type")
    private String type;

    @Column(name = "achievement_value")
    private Integer value;
}
