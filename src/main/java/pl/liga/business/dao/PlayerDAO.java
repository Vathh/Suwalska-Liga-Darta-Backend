package pl.liga.business.dao;

import pl.liga.domain.Player;

import java.util.List;

public interface PlayerDAO {

    List<Player> findAllWithoutResults();

    void savePlayer(Player player);

    List<Player> findPlayersByIdsWithoutResultsAndAchievements(List<Integer> playersIds);

    List<Player> findAllWithAchievementsAndResults();

}
