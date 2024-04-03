package pl.liga.business.dao;

import pl.liga.domain.Player;

import java.util.List;

public interface PlayerDAO {

    List<Player> findAll();

    void savePlayer(Player player);

    List<Player> findSpecifiedPlayers(List<String> playersNames);

}
