package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = {"playerId", "name"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "league_player")
//@NamedEntityGraph(name = "PlayerEntity.noAssociations", attributeNodes = {
//        @NamedAttributeNode("playerId"),
//        @NamedAttributeNode("name")
//})
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "player_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
    private List<AchievementEntity> achievements;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
    private List<ResultEntity> results;

    public PlayerEntity(Integer playerId, String name){
        this.playerId = playerId;
        this.name = name;
    }
}
