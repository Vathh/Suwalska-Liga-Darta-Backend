package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.liga.business.dao.PlayerDAO;
import pl.liga.domain.Player;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerDAO playerDAO;

    @Transactional
    public void addPlayer(Player player){
        playerDAO.savePlayer(player);
    }

    @Transactional
    public List<Player> getPlayers(){
        return playerDAO.findAll();
    };

    @Transactional
    public List<Player> findSpecifiedPlayers(List<String> playersNames){
        return playerDAO.findSpecifiedPlayers(playersNames);
    }
}
