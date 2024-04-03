package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.PlayerEntity;

import java.util.List;
import java.util.Set;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Integer> {

    @Query("""
            SELECT pl FROM PlayerEntity pl
            WHERE pl.name IN :playersNames
            """)
    Set<PlayerEntity> findSpecifiedPlayers(final @Param("playersNames")List<String> playersNames);
}
