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
public class HFRepository implements AchievementDAO {

    private final AchievementJpaRepository achievementJpaRepository;

    private final AchievementEntityMapper achievementEntityMapper;

    @Override
    public List<Achievement> findAll() {
        return null;
    }

    @Override
    public void saveHFs(List<Achievement> achievements) {

    }
}
