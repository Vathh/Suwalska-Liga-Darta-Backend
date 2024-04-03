package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.MatchEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

import java.util.Optional;

@Repository
public interface MatchJpaRepository extends JpaRepository<MatchEntity, Integer> {

    @Query("""
            SELECT mt FROM MatchEntity mt
            WHERE mt.markup = :markup
            AND mt.tournament = :tournamentEntity
            """)
    Optional<MatchEntity> findMatch(final @Param("markup") String markup, @Param("tournamentEntity") TournamentEntity tournamentEntity);
}
