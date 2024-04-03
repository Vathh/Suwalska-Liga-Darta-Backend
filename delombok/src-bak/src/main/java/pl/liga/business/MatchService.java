package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.liga.business.dao.MatchDAO;
import pl.liga.domain.Match;
import pl.liga.domain.Player;
import pl.liga.domain.Tournament;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MatchService {

    private final MatchDAO matchDAO;

    private final BracketService bracketService;

    @Transactional
    public void addMatches(List<Player> players, Tournament tournament){
        List<Match> matches = bracketService.getBracket(players, tournament);
        matchDAO.saveMatches(matches);
    }

    @Transactional
    public List<Match> findAllMatches(){
        return matchDAO.findAll();
    }

    @Transactional
    public void endMatch(Match match, Player loser, Player winner){
        Match matchToEnd = matchDAO.findMatch(match.getMarkup(), match.getTournament());
        Match winnerDestinationMatch = matchDAO.findMatch(match.getWinnerDestinationMarkup(), match.getTournament());

        Match matchToEndToSave = matchToEnd.withLoser(loser).withWinner(winner);
        matchDAO.saveMatch(matchToEndToSave);
        Match winnerDestinationMatchToSave;
        if(winnerDestinationMatch.getPlayerA() == null){
            winnerDestinationMatchToSave = winnerDestinationMatch.withPlayerA(winner);
        }else{
            winnerDestinationMatchToSave = winnerDestinationMatch.withPlayerB(winner);
        }
        matchDAO.saveMatch(winnerDestinationMatchToSave);

        Match loserDestinationMatchToSave;

        if(match.getLoserDestinationMarkup() == null || match.getLoserDestinationMarkup().isEmpty()){

        }else{
            Match loserDestinationMatch = matchDAO.findMatch(match.getLoserDestinationMarkup(), match.getTournament());

            if(loserDestinationMatch.getPlayerA() == null){
                loserDestinationMatchToSave = loserDestinationMatch.withPlayerA(loser);
            }else{
                loserDestinationMatchToSave = loserDestinationMatch.withPlayerB(loser);
            }
            matchDAO.saveMatch(loserDestinationMatchToSave);
        }
    }
}
