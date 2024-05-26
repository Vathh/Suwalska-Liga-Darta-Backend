package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.TournamentEntity;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TournamentJpaRepository extends JpaRepository<TournamentEntity, Integer> {

    @Query("""
            SELECT new TournamentEntity(tm.tournamentId, tm.date, tm.closed) FROM TournamentEntity tm
            WHERE tm.tournamentId = :tournamentId
            """)
    Optional<TournamentEntity> findByIdWithoutResultsAchievementsMatchesSeason(final @Param("tournamentId")Integer tournamentId);

    @Query("""
            SELECT tm FROM TournamentEntity tm
            WHERE tm.active = true
            """)
    Optional<TournamentEntity> findActiveTournament();

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
