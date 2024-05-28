package pl.liga.infrastructure.database.repository.mapper;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Match;
import pl.liga.infrastructure.database.entity.MatchEntity;

@Component
public class MatchEntityMapperImpl {

    private final PlayerEntityMapperImpl playerEntityMapper;
    private final TournamentEntityMapperImpl tournamentEntityMapper;

    public MatchEntityMapperImpl(PlayerEntityMapperImpl playerEntityMapper,
                                 @Lazy TournamentEntityMapperImpl tournamentEntityMapper){
        this.playerEntityMapper = playerEntityMapper;
        this.tournamentEntityMapper = tournamentEntityMapper;
    }

    public Match mapFromEntityWithoutResultsAndAchievementsWithTournamentId(MatchEntity entity){
        return Match.builder()
                .matchId(entity.getMatchId())
                .playerA(playerEntityMapper.mapFromEntityWithoutResultsAndAchievements(entity.getPlayerA()))
                .playerB(playerEntityMapper.mapFromEntityWithoutResultsAndAchievements(entity.getPlayerB()))
                .winner(playerEntityMapper.mapFromEntityWithoutResultsAndAchievements(entity.getWinner()))
                .loser(playerEntityMapper.mapFromEntityWithoutResultsAndAchievements(entity.getLoser()))
                .tournament(tournamentEntityMapper.mapFromEntityIdOnly(entity.getTournament()))
                .markup(entity.getMarkup())
                .winnerDestinationMarkup(entity.getWinnerDestinationMarkup())
                .loserDestinationMarkup(entity.getLoserDestinationMarkup())
                .points(entity.getPoints())
                .active(entity.getActive())
                .build();
    }

    public Match mapFromEntity(MatchEntity entity){
        return Match.builder()
                .matchId(entity.getMatchId())
                .playerA(playerEntityMapper.mapFromEntity(entity.getPlayerA()))
                .playerB(playerEntityMapper.mapFromEntity(entity.getPlayerB()))
                .winner(playerEntityMapper.mapFromEntity(entity.getWinner()))
                .loser(playerEntityMapper.mapFromEntity(entity.getLoser()))
                .tournament(tournamentEntityMapper.mapFromEntity(entity.getTournament()))
                .markup(entity.getMarkup())
                .winnerDestinationMarkup(entity.getWinnerDestinationMarkup())
                .loserDestinationMarkup(entity.getLoserDestinationMarkup())
                .points(entity.getPoints())
                .active(entity.getActive())
                .build();
    }

    public MatchEntity mapToEntity(Match match){
        return MatchEntity.builder()
                .matchId(match.getMatchId())
                .playerA(playerEntityMapper.mapToEntity(match.getPlayerA()))
                .playerB(playerEntityMapper.mapToEntity(match.getPlayerB()))
                .winner(playerEntityMapper.mapToEntity(match.getWinner()))
                .loser(playerEntityMapper.mapToEntity(match.getLoser()))
                .tournament(tournamentEntityMapper.mapToEntity(match.getTournament()))
                .markup(match.getMarkup())
                .winnerDestinationMarkup(match.getWinnerDestinationMarkup())
                .loserDestinationMarkup(match.getLoserDestinationMarkup())
                .points(match.getPoints())
                .active(match.getActive())
                .build();
    }
}
