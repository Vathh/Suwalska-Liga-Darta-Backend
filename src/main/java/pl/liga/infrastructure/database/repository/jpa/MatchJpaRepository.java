package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.MatchEntity;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MatchJpaRepository extends JpaRepository<MatchEntity, Integer> {

    @Query("""
            SELECT mt FROM MatchEntity mt
            WHERE mt.markup = :markup
            AND mt.tournament.tournamentId = :tournamentId
            """)
    Optional<MatchEntity> findMatch(final @Param("markup") String markup, @Param("tournamentId") Integer tournamentId);

    @Query("""
            SELECT mt FROM MatchEntity mt
            WHERE mt.tournament.tournamentId = :tournamentId
            """)
    Set<MatchEntity> findMatchesByTournamentId(final @Param("tournamentId") Integer tournamentId);

    @Query("""
            SELECT mt FROM MatchEntity mt
            WHERE mt.active = true
            """)
    Set<MatchEntity> findActiveMatches();

    @Modifying
    @Query("""
            UPDATE MatchEntity mt 
            SET mt.winner.playerId = :winnerId, mt.loser.playerId = :loserId, mt.active = false
            WHERE mt.matchId = :matchId
            """)
    void updateMatch(final @Param("matchId") Integer matchId,
                     final @Param("winnerId") Integer winnerId,
                     final @Param("loserId") Integer loserId);

    @Modifying
    @Query("""
            UPDATE MatchEntity mt
            SET mt.playerA.playerId = :playerId
            WHERE mt.matchId = :matchId
            """)
    void setPlayerA(final @Param("matchId") Integer matchId,
                    final @Param("playerId") Integer playerId);

    @Modifying
    @Query("""
            UPDATE MatchEntity mt
            SET mt.playerB.playerId = :playerId
            WHERE mt.matchId = :matchId
            """)
    void setPlayerB(final @Param("matchId") Integer matchId,
                    final @Param("playerId") Integer playerId);

    @Modifying
    @Query("""
            DELETE FROM MatchEntity mt
            WHERE mt.tournament.tournamentId = :tournamentId
            """)
    void deleteMatchesByTournamentId(@Param("tournamentId") Integer tournamentId);
}
