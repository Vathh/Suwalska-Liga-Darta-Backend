package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.AchievementEntity;
import pl.liga.infrastructure.database.entity.SeasonEntity;

import java.util.Date;

@Repository
public interface SeasonJpaRepository extends JpaRepository<SeasonEntity, Integer> {

    SeasonEntity findByName(String name);

    SeasonEntity findBySeasonId(Integer seasonId);
}
