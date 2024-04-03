package pl.liga.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = {"schemaMatchId", "schemaSize"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "league_schema_match")
public class SchemaMatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schema_match_id")
    private Integer schemaMatchId;

    @Column(name = "schema_size")
    private Integer schemaSize;

    @Column(name = "player_a_number")
    private Integer playerANumber;

    @Column(name = "player_b_number")
    private Integer playerBNumber;

    @Column(name = "markup")
    private String markup;

    @Column(name = "winner_markup")
    private String winnerDestinationMarkup;

    @Column(name = "loser_markup")
    private String loserDestinationMarkup;

    @Column(name = "points")
    private Integer points;
}
