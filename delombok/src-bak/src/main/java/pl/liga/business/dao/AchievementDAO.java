package pl.liga.business.dao;

import pl.liga.domain.Achievement;

import java.util.List;

public interface AchievementDAO {

    List<Achievement> findAll();

    void saveHFs(List<Achievement> achievements);

}
