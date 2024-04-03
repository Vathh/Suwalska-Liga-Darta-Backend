package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.liga.domain.Achievement;
import pl.liga.infrastructure.database.entity.AchievementEntity;

import java.util.List;

@Repository
public interface AchievementJpaRepository extends JpaRepository<AchievementEntity, Integer> {

}
