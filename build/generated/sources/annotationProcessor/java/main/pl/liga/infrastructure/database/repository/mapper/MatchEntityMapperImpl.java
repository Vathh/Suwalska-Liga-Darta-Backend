package pl.liga.infrastructure.database.repository.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.liga.domain.Match;
import pl.liga.infrastructure.database.entity.MatchEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T09:41:34+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class MatchEntityMapperImpl implements MatchEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;
    @Autowired
    private PlayerEntityMapper playerEntityMapper;
    @Autowired
    private TournamentEntityMapper tournamentEntityMapper;

    @Override
    public Match mapFromEntityWithoutResultsAndAchievementsWithTournamentId(MatchEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Match.MatchBuilder match = Match.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, match );

        match.playerA( playerEntityMapper.mapFromEntityWithoutResultsAndAchievements( entity.getPlayerA() ) );
        match.playerB( playerEntityMapper.mapFromEntityWithoutResultsAndAchievements( entity.getPlayerB() ) );
        match.winner( playerEntityMapper.mapFromEntityWithoutResultsAndAchievements( entity.getWinner() ) );
        match.loser( playerEntityMapper.mapFromEntityWithoutResultsAndAchievements( entity.getLoser() ) );
        match.tournament( tournamentEntityMapper.mapIdOnlyFromEntity( entity.getTournament() ) );
        match.matchId( entity.getMatchId() );
        match.markup( entity.getMarkup() );
        match.winnerDestinationMarkup( entity.getWinnerDestinationMarkup() );
        match.loserDestinationMarkup( entity.getLoserDestinationMarkup() );
        match.points( entity.getPoints() );
        match.active( entity.getActive() );

        return match.build();
    }

    @Override
    public Match mapFromEntity(MatchEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Match.MatchBuilder match = Match.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, match );

        match.playerA( playerEntityMapper.mapFromEntity( entity.getPlayerA() ) );
        match.playerB( playerEntityMapper.mapFromEntity( entity.getPlayerB() ) );
        match.winner( playerEntityMapper.mapFromEntity( entity.getWinner() ) );
        match.loser( playerEntityMapper.mapFromEntity( entity.getLoser() ) );
        match.tournament( tournamentEntityMapper.mapFromEntity( entity.getTournament() ) );
        match.matchId( entity.getMatchId() );
        match.markup( entity.getMarkup() );
        match.winnerDestinationMarkup( entity.getWinnerDestinationMarkup() );
        match.loserDestinationMarkup( entity.getLoserDestinationMarkup() );
        match.points( entity.getPoints() );
        match.active( entity.getActive() );

        return match.build();
    }

    @Override
    public MatchEntity mapToEntity(Match match) {
        if ( match == null ) {
            return null;
        }

        MatchEntity.MatchEntityBuilder matchEntity = MatchEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( match, matchEntity );

        matchEntity.playerA( playerEntityMapper.mapToEntity( match.getPlayerA() ) );
        matchEntity.playerB( playerEntityMapper.mapToEntity( match.getPlayerB() ) );
        matchEntity.winner( playerEntityMapper.mapToEntity( match.getWinner() ) );
        matchEntity.loser( playerEntityMapper.mapToEntity( match.getLoser() ) );
        matchEntity.tournament( tournamentEntityMapper.mapToEntity( match.getTournament() ) );
        matchEntity.matchId( match.getMatchId() );
        matchEntity.markup( match.getMarkup() );
        matchEntity.winnerDestinationMarkup( match.getWinnerDestinationMarkup() );
        matchEntity.loserDestinationMarkup( match.getLoserDestinationMarkup() );
        matchEntity.points( match.getPoints() );
        matchEntity.active( match.getActive() );

        return matchEntity.build();
    }
}
