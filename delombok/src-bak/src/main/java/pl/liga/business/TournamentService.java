package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.liga.business.dao.TournamentDAO;
import pl.liga.domain.Match;
import pl.liga.domain.Tournament;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TournamentService {

    private final TournamentDAO tournamentDAO;

    @Transactional
    public void addTournament(Tournament tournament){
        tournamentDAO.saveTournament(tournament);
    };

    @Transactional
    public Tournament getRandomTournament(){
        return tournamentDAO.getRandomTournament();
    }

}
