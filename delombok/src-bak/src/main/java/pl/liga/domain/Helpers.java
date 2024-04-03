package pl.liga.domain;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public List<Player> getRandomPlayers(){
        List<Player> players = new ArrayList<>();

        for(int i = 0; i < 36; i++){
            players.add(Player.builder()
                            .playerId(i)
                            .name("player" + i)
                            .total(i)
                            .participation(i)
                            .build());
        }

        return players;
    }
}
