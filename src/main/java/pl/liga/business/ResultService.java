package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.liga.business.dao.ResultDAO;
import pl.liga.domain.Player;
import pl.liga.domain.Result;
import pl.liga.domain.Tournament;

@Slf4j
@Service
@AllArgsConstructor
public class ResultService {

    private final ResultDAO resultDAO;

    @Transactional
    public void addResult(Integer playerId, Integer tournamentId, Integer pointsEarned){
        resultDAO.addResult(Result.builder()
                        .player(Player.builder().playerId(playerId).build())
                        .tournament(Tournament.builder().tournamentId(tournamentId).build())
                        .pointsEarned(pointsEarned)
                        .build());
    }
}
