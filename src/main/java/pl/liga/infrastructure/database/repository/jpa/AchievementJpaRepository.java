package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.AchievementEntity;

@Repository
public interface AchievementJpaRepository extends JpaRepository<AchievementEntity, Integer> {

}
