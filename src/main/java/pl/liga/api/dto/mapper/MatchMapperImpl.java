package pl.liga.api.dto.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.liga.api.dto.MatchDTO;
import pl.liga.domain.Match;

@Component
@AllArgsConstructor
public class MatchMapperImpl {

    private final PlayerMapper playerMapper;

    public MatchDTO map(final Match match){
        return MatchDTO.builder()
                .matchId(match.getMatchId())
                .tournamentId(match.getTournament().getTournamentId())
                .playerA(match.getPlayerA() == null ? null : playerMapper.mapWithoutAchievementsResults(match.getPlayerA()))
                .playerB(match.getPlayerB() == null ? null : playerMapper.mapWithoutAchievementsResults(match.getPlayerB()))
                .winner(match.getWinner() == null ? null : playerMapper.mapWithoutAchievementsResults(match.getWinner()))
                .loser(match.getLoser() == null ? null : playerMapper.mapWithoutAchievementsResults(match.getLoser()))
                .markup(match.getMarkup())
                .winnerDestinationMarkup(match.getWinnerDestinationMarkup())
                .loserDestinationMarkup(match.getLoserDestinationMarkup())
                .points(match.getPoints())
                .active(match.getActive())
                .build();
    }
}
