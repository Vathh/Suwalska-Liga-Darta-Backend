package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "playerId")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "league_player")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "player_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
    private Set<AchievementEntity> achievements;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
    private Set<ResultEntity> results;
}
