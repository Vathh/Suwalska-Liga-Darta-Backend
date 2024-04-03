package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.AchievementDAO;
import pl.liga.domain.Achievement;
import pl.liga.infrastructure.database.repository.jpa.AchievementJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.AchievementEntityMapper;

import java.util.List;

@Repository
@AllArgsConstructor
public class AchievementRepository implements AchievementDAO {

    private final AchievementJpaRepository achievementJpaRepository;
    private final AchievementEntityMapper achievementEntityMapper;

    @Override
    public List<Achievement> findAll() {
        return null;
    }

    @Override
    public void addAchievements(List<Achievement> achievements) {
        achievementJpaRepository.saveAllAndFlush(achievements.stream().map(achievementEntityMapper::mapToEntity).toList());
    }
}
