package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.liga.api.dto.StartTournamentDTO;
import pl.liga.business.dao.MatchDAO;
import pl.liga.business.dao.TournamentDAO;
import pl.liga.domain.Match;
import pl.liga.domain.Player;
import pl.liga.domain.Tournament;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TournamentService {

    private final TournamentDAO tournamentDAO;
    private final MatchDAO matchDAO;
    private final PlayerService playerService;
    private final BracketService bracketService;

    @Transactional
    public List<Tournament> findAllWithoutResultsAchievementsMatches(){
        return tournamentDAO.findAllWithoutResultsAchievementsMatches();
    }
    @Transactional
    public Tournament findByIdWithoutMatches(Integer tournamentId){
        return tournamentDAO.findByIdWithoutMatches(tournamentId);
    }
    @Transactional
    public Tournament findActiveTournament(){
        return tournamentDAO.findActiveTournament();
    }
    @Transactional
    public void saveTournament(Tournament tournament){
        tournamentDAO.saveTournament(tournament);
    }
    @Transactional
    public void startTournament(StartTournamentDTO dto){
        List<Integer> playersIds = List.of(dto.getPlayersIds());

        List<Player> players = playerService.findPlayersByIdsWithoutResultsAndAchievements(playersIds);

        int size;
        if(players.size() > 32 && players.size() <= 48){
            size = 48;
        } else if (players.size() <= 32 && players.size() > 16) {
            size = 32;
        } else if (players.size() <= 16 && players.size() > 8) {
            size = 16;
        }else {
            size = 16;
        }

        Tournament tournament = tournamentDAO.findByIdWithoutMatches(dto.getTournamentId());

        List<Match> matches = bracketService.getBracket(players, tournament);

        Tournament tournamentToUpdate = tournament.withMatches(matches).withActive(true).withSize(size);

        saveTournament(tournamentToUpdate);
    }
    @Transactional
    public void endTournament(Integer tournamentId){
        tournamentDAO.endTournament(tournamentId);
    }
    @Transactional
    public void deleteTournament(Integer tournamentId){
        tournamentDAO.deleteTournament(tournamentId);
    }
    @Transactional
    public void cancelActiveTournament(Integer tournamentId) {
        tournamentDAO.cancelActiveTournament(tournamentId);
        matchDAO.deleteMatchesByTournamentId(tournamentId);
    }
}
