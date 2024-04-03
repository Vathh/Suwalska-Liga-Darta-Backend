package pl.liga.business.dao;

import pl.liga.domain.Achievement;

import java.util.List;

public interface AchievementDAO {

    List<Achievement> findAll();

    void addAchievements(List<Achievement> achievements);

}
