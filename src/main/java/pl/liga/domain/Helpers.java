package pl.liga.domain;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static String MAX = "MAX";
    public static String ONESEVENTY = "170PLUS";
    public static String HF = "HF";
    public static String QF = "QF";

    public List<Player> getRandomPlayers(){
        List<Player> players = new ArrayList<>();

        for(int i = 0; i < 36; i++){
            players.add(Player.builder()
                            .playerId(i)
                            .name("player" + i)
                            .build());
        }

        return players;
    }
}
