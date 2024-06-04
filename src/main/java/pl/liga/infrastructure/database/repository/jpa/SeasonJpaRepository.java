package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.AchievementEntity;
import pl.liga.infrastructure.database.entity.SeasonEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface SeasonJpaRepository extends JpaRepository<SeasonEntity, Integer> {

    SeasonEntity findByName(String name);

    @Query("""
            SELECT sn FROM SeasonEntity sn
            LEFT JOIN FETCH sn.tournaments tm
            LEFT JOIN FETCH tm.achievements ah
            LEFT JOIN FETCH ah.player
            LEFT JOIN FETCH tm.results rs
            LEFT JOIN FETCH rs.player
            WHERE sn.seasonId = :seasonId
            """)
    SeasonEntity findBySeasonId(final @Param("seasonId") Integer seasonId);

    @Query("""
            SELECT sn FROM SeasonEntity sn
            LEFT JOIN FETCH sn.tournaments
            """)
    List<SeasonEntity> findAllWithTournaments();

    @Query("""
            SELECT sn FROM SeasonEntity sn
            LEFT JOIN FETCH sn.tournaments            
            LEFT JOIN FETCH sn.tournaments.results
            LEFT JOIN FETCH sn.tournaments.achievements
            LEFT JOIN FETCH sn.tournaments.results.player
            WHERE sn.toDelete = false
            """)
    List<SeasonEntity> findAll();

    @Modifying
    @Query("""
            UPDATE SeasonEntity sn
            SET sn.toDelete = true
            WHERE sn.seasonId = :seasonId
            """)
    void deleteBySeasonId(final @Param("seasonId") Integer seasonId);
}
