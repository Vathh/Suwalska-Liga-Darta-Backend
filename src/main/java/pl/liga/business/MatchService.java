package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.liga.api.dto.MatchResultDTO;
import pl.liga.api.dto.UpdateMatchDTO;
import pl.liga.business.dao.MatchDAO;
import pl.liga.domain.Match;
import pl.liga.domain.Player;
import pl.liga.domain.Result;
import pl.liga.domain.Tournament;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class MatchService {

    private final MatchDAO matchDAO;
    private final BracketService bracketService;
    private final ResultService resultService;
    private final TournamentService tournamentService;
    private final AchievementService achievementService;

    @Transactional
    public List<Match> findMatchesByTournamentId(Integer tournamentId){
        return matchDAO.findMatchesByTournamentId(tournamentId);
    }

    @Transactional
    public List<Match> findActiveMatches(){
        List<Match> matches = matchDAO.findActiveMatches();

        return matches.stream().filter(match -> match.getPlayerA() != null && match.getPlayerB() != null).toList();
    }

    @Transactional
    public void addMatchResult(MatchResultDTO matchResultDTO){
        updateMatch(matchResultDTO.getUpdateMatchDTO());
        achievementService.addAchievements(matchResultDTO.getMatchAchievementsDTO());
    }

    @Transactional
    public void updateMatch(UpdateMatchDTO dto){
        matchDAO.updateMatch(dto.getMatchId(), dto.getWinnerId(), dto.getLoserId());

        if(dto.getWinnerDestinationMarkup().startsWith("FINAL")){
            handleFinal(dto);
            return;
        }

        handleWinnerDestination(dto);

        handleLoserDestination(dto);

    }

    private void handleWinnerDestination(UpdateMatchDTO dto){

        Match winnerDestinationMatch = matchDAO.findMatch(dto.getWinnerDestinationMarkup(), dto.getTournamentId());
        if(winnerDestinationMatch.getPlayerA() == null){
            matchDAO.setPlayerA(winnerDestinationMatch.getMatchId(), dto.getWinnerId());
        }else{
            matchDAO.setPlayerB(winnerDestinationMatch.getMatchId(), dto.getWinnerId());
        }

        if((winnerDestinationMatch.getPlayerA() != null && winnerDestinationMatch.getPlayerA().getName().equals("EMPTY")) ||
                (winnerDestinationMatch.getPlayerB() != null && winnerDestinationMatch.getPlayerB().getName().equals("EMPTY"))){
            UpdateMatchDTO handleEmptyMatchDto = UpdateMatchDTO.builder()
                    .tournamentId(dto.getTournamentId())
                    .matchId(winnerDestinationMatch.getMatchId())
                    .winnerId(dto.getWinnerId())
                    .loserId(1)
                    .markup(winnerDestinationMatch.getMarkup())
                    .winnerDestinationMarkup(winnerDestinationMatch.getWinnerDestinationMarkup())
                    .loserDestinationMarkup(winnerDestinationMatch.getLoserDestinationMarkup())
                    .points(winnerDestinationMatch.getPoints())
                    .build();
            updateMatch(handleEmptyMatchDto);
        }
    }

    private void handleLoserDestination(UpdateMatchDTO dto){
        if(dto.getLoserDestinationMarkup() == null || dto.getLoserDestinationMarkup().isEmpty() || Objects.equals(dto.getLoserDestinationMarkup(), "")){
            if(!dto.getLoserId().equals(1)){
                resultService.addResult(dto.getLoserId(), dto.getTournamentId(), dto.getPoints());
            }
        }else{
            Match loserDestinationMatch = matchDAO.findMatch(dto.getLoserDestinationMarkup(), dto.getTournamentId());

            if(loserDestinationMatch.getPlayerA() == null){
                matchDAO.setPlayerA(loserDestinationMatch.getMatchId(), dto.getLoserId());
            }else{
                matchDAO.setPlayerB(loserDestinationMatch.getMatchId(), dto.getLoserId());
            }

            if((loserDestinationMatch.getPlayerA() != null && loserDestinationMatch.getPlayerA().getName().equals("EMPTY")) ||
                    (loserDestinationMatch.getPlayerB() != null && loserDestinationMatch.getPlayerB().getName().equals("EMPTY"))){

                UpdateMatchDTO handleEmptyMatchDto = UpdateMatchDTO.builder()
                        .tournamentId(dto.getTournamentId())
                        .matchId(loserDestinationMatch.getMatchId())
                        .winnerId(dto.getLoserId())
                        .loserId(1)
                        .markup(loserDestinationMatch.getMarkup())
                        .winnerDestinationMarkup(loserDestinationMatch.getWinnerDestinationMarkup())
                        .loserDestinationMarkup(loserDestinationMatch.getLoserDestinationMarkup())
                        .points(loserDestinationMatch.getPoints())
                        .build();
                updateMatch(handleEmptyMatchDto);
            }else if(loserDestinationMatch.getPlayerA() != null && dto.getLoserId() == 1){
                UpdateMatchDTO handleEmptyMatchDto = UpdateMatchDTO.builder()
                        .tournamentId(dto.getTournamentId())
                        .matchId(loserDestinationMatch.getMatchId())
                        .winnerId(loserDestinationMatch.getPlayerA().getPlayerId())
                        .loserId(1)
                        .markup(loserDestinationMatch.getMarkup())
                        .winnerDestinationMarkup(loserDestinationMatch.getWinnerDestinationMarkup())
                        .loserDestinationMarkup(loserDestinationMatch.getLoserDestinationMarkup())
                        .points(loserDestinationMatch.getPoints())
                        .build();
                updateMatch(handleEmptyMatchDto);
            }
        }
    }

    private void handleFinal(UpdateMatchDTO dto){
        if(!dto.getLoserId().equals(1)){
            resultService.addResult(dto.getLoserId(), dto.getTournamentId(), dto.getPoints());
        }
        resultService.addResult(dto.getWinnerId(), dto.getTournamentId(), Integer.parseInt(dto.getWinnerDestinationMarkup().substring(5)));
        tournamentService.endTournament(dto.getTournamentId());
    }
}
