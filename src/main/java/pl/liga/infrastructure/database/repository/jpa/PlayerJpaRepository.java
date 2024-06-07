package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.PlayerEntity;

import java.util.List;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Integer> {
    @Query("""
            SELECT pl FROM PlayerEntity pl
            LEFT JOIN FETCH pl.achievements
            """)
    List<PlayerEntity> findAllWithAchievements();

    @Query("""
            SELECT new PlayerEntity(pl.playerId, pl.name) FROM PlayerEntity pl
            WHERE pl.playerId IN :playersIds
            """)
    List<PlayerEntity> findPlayersByIdsWithoutResultsAndAchievements(final @Param("playersIds")List<Integer> playersIds);
}
