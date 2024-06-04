package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.TournamentEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentJpaRepository extends JpaRepository<TournamentEntity, Integer> {

    @Query("""
            SELECT new TournamentEntity(tm.tournamentId, tm.date, tm.closed) FROM TournamentEntity tm
            WHERE tm.tournamentId = :tournamentId
            """)
    Optional<TournamentEntity> findByIdWithoutResultsAchievementsMatchesSeason(final @Param("tournamentId")Integer tournamentId);

    @Query("""
            SELECT tm FROM TournamentEntity tm
            LEFT JOIN FETCH tm.matches
            LEFT JOIN FETCH tm.matches.playerA
            LEFT JOIN FETCH tm.matches.playerB
            LEFT JOIN FETCH tm.season
            WHERE tm.active = true
            """)
    Optional<TournamentEntity> findActiveTournament();

    @Query("""
            SELECT tm FROM TournamentEntity tm
            LEFT JOIN FETCH tm.season
            """)
    List<TournamentEntity> findAll();

    @Query("""
            SELECT tm FROM TournamentEntity tm
            LEFT JOIN FETCH tm.results
            LEFT JOIN FETCH tm.results.player
            LEFT JOIN FETCH tm.achievements
            LEFT JOIN FETCH tm.season
            WHERE tm.tournamentId = :tournamentId           
            """)
    Optional<TournamentEntity> findByIdWithoutMatches(final @Param("tournamentId")Integer tournamentId);

    @Modifying
    @Query("""
            UPDATE TournamentEntity tm
            SET tm.active = false, tm.closed = true
            WHERE tm.tournamentId = :tournamentId
            """)
    void endTournament(final @Param("tournamentId") Integer tournamentId);

    @Modifying
    @Query("""
            UPDATE TournamentEntity tm
            SET tm.active = false
            WHERE tm.tournamentId = :tournamentId
            """)
    void cancelActiveTournament(Integer tournamentId);
}
