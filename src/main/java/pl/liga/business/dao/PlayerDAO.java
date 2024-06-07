package pl.liga.business.dao;

import pl.liga.domain.Player;

import java.util.List;

public interface PlayerDAO {
    List<Player> findAllWithoutResults();
    List<Player> findPlayersByIdsWithoutResultsAndAchievements(List<Integer> playersIds);
    void savePlayer(Player player);
}
