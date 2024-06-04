package pl.liga.infrastructure.database.repository.mapper;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.liga.domain.Achievement;
import pl.liga.domain.Match;
import pl.liga.domain.Player;
import pl.liga.domain.Result;
import pl.liga.domain.Season;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.AchievementEntity;
import pl.liga.infrastructure.database.entity.MatchEntity;
import pl.liga.infrastructure.database.entity.PlayerEntity;
import pl.liga.infrastructure.database.entity.ResultEntity;
import pl.liga.infrastructure.database.entity.SeasonEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T19:02:45+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class MatchEntityMapperImpl implements MatchEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;

    @Override
    public Match mapFromEntity(MatchEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Match.MatchBuilder match = Match.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, match );

        match.matchId( entity.getMatchId() );
        match.playerA( playerEntityToPlayer( entity.getPlayerA() ) );
        match.playerB( playerEntityToPlayer( entity.getPlayerB() ) );
        match.winner( playerEntityToPlayer( entity.getWinner() ) );
        match.loser( playerEntityToPlayer( entity.getLoser() ) );
        match.tournament( tournamentEntityToTournament( entity.getTournament() ) );
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

        matchEntity.matchId( match.getMatchId() );
        matchEntity.playerA( playerToPlayerEntity( match.getPlayerA() ) );
        matchEntity.playerB( playerToPlayerEntity( match.getPlayerB() ) );
        matchEntity.winner( playerToPlayerEntity( match.getWinner() ) );
        matchEntity.loser( playerToPlayerEntity( match.getLoser() ) );
        matchEntity.tournament( tournamentToTournamentEntity( match.getTournament() ) );
        matchEntity.markup( match.getMarkup() );
        matchEntity.winnerDestinationMarkup( match.getWinnerDestinationMarkup() );
        matchEntity.loserDestinationMarkup( match.getLoserDestinationMarkup() );
        matchEntity.points( match.getPoints() );
        matchEntity.active( match.getActive() );

        return matchEntity.build();
    }

    @Override
    public Player playerEntityToPlayer(PlayerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, player );

        player.playerId( entity.getPlayerId() );
        player.name( entity.getName() );

        return player.build();
    }

    @Override
    public Tournament tournamentEntityToTournament(TournamentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Tournament.TournamentBuilder tournament = Tournament.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, tournament );

        tournament.tournamentId( entity.getTournamentId() );
        tournament.date( entity.getDate() );
        tournament.active( entity.getActive() );
        tournament.closed( entity.getClosed() );
        tournament.size( entity.getSize() );

        return tournament.build();
    }

    protected ResultEntity resultToResultEntity(Result result) {
        if ( result == null ) {
            return null;
        }

        ResultEntity.ResultEntityBuilder resultEntity = ResultEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( result, resultEntity );

        resultEntity.resultId( result.getResultId() );
        resultEntity.player( playerToPlayerEntity( result.getPlayer() ) );
        resultEntity.tournament( tournamentToTournamentEntity( result.getTournament() ) );
        resultEntity.pointsEarned( result.getPointsEarned() );

        return resultEntity.build();
    }

    protected Set<ResultEntity> resultListToResultEntitySet(List<Result> list) {
        Set<ResultEntity> target = cycleAvoidingMappingContext.getMappedInstance( list, Set.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        Set<ResultEntity> set = new LinkedHashSet<ResultEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        cycleAvoidingMappingContext.storeMappedInstance( list, set );

        for ( Result result : list ) {
            set.add( resultToResultEntity( result ) );
        }

        return set;
    }

    protected Set<AchievementEntity> achievementListToAchievementEntitySet(List<Achievement> list) {
        Set<AchievementEntity> target = cycleAvoidingMappingContext.getMappedInstance( list, Set.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        Set<AchievementEntity> set = new LinkedHashSet<AchievementEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        cycleAvoidingMappingContext.storeMappedInstance( list, set );

        for ( Achievement achievement : list ) {
            set.add( achievementToAchievementEntity( achievement ) );
        }

        return set;
    }

    protected Set<MatchEntity> matchListToMatchEntitySet(List<Match> list) {
        Set<MatchEntity> target = cycleAvoidingMappingContext.getMappedInstance( list, Set.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        Set<MatchEntity> set = new LinkedHashSet<MatchEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        cycleAvoidingMappingContext.storeMappedInstance( list, set );

        for ( Match match : list ) {
            set.add( mapToEntity( match ) );
        }

        return set;
    }

    protected Set<TournamentEntity> tournamentListToTournamentEntitySet(List<Tournament> list) {
        Set<TournamentEntity> target = cycleAvoidingMappingContext.getMappedInstance( list, Set.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        Set<TournamentEntity> set = new LinkedHashSet<TournamentEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        cycleAvoidingMappingContext.storeMappedInstance( list, set );

        for ( Tournament tournament : list ) {
            set.add( tournamentToTournamentEntity( tournament ) );
        }

        return set;
    }

    protected SeasonEntity seasonToSeasonEntity(Season season) {
        if ( season == null ) {
            return null;
        }

        SeasonEntity.SeasonEntityBuilder seasonEntity = SeasonEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( season, seasonEntity );

        seasonEntity.seasonId( season.getSeasonId() );
        seasonEntity.name( season.getName() );
        seasonEntity.startDate( season.getStartDate() );
        seasonEntity.endDate( season.getEndDate() );
        seasonEntity.toDelete( season.getToDelete() );
        seasonEntity.tournaments( tournamentListToTournamentEntitySet( season.getTournaments() ) );
        seasonEntity.rankCount( season.getRankCount() );

        return seasonEntity.build();
    }

    protected TournamentEntity tournamentToTournamentEntity(Tournament tournament) {
        if ( tournament == null ) {
            return null;
        }

        TournamentEntity.TournamentEntityBuilder tournamentEntity = TournamentEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( tournament, tournamentEntity );

        tournamentEntity.tournamentId( tournament.getTournamentId() );
        tournamentEntity.date( tournament.getDate() );
        tournamentEntity.results( resultListToResultEntitySet( tournament.getResults() ) );
        tournamentEntity.achievements( achievementListToAchievementEntitySet( tournament.getAchievements() ) );
        tournamentEntity.matches( matchListToMatchEntitySet( tournament.getMatches() ) );
        tournamentEntity.size( tournament.getSize() );
        tournamentEntity.active( tournament.getActive() );
        tournamentEntity.closed( tournament.getClosed() );
        tournamentEntity.season( seasonToSeasonEntity( tournament.getSeason() ) );

        return tournamentEntity.build();
    }

    protected AchievementEntity achievementToAchievementEntity(Achievement achievement) {
        if ( achievement == null ) {
            return null;
        }

        AchievementEntity.AchievementEntityBuilder achievementEntity = AchievementEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( achievement, achievementEntity );

        achievementEntity.achievementId( achievement.getAchievementId() );
        achievementEntity.player( playerToPlayerEntity( achievement.getPlayer() ) );
        achievementEntity.tournament( tournamentToTournamentEntity( achievement.getTournament() ) );
        achievementEntity.type( achievement.getType() );
        achievementEntity.value( achievement.getValue() );

        return achievementEntity.build();
    }

    protected PlayerEntity playerToPlayerEntity(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerEntity.PlayerEntityBuilder playerEntity = PlayerEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( player, playerEntity );

        playerEntity.playerId( player.getPlayerId() );
        playerEntity.name( player.getName() );
        playerEntity.achievements( achievementListToAchievementEntitySet( player.getAchievements() ) );
        playerEntity.results( resultListToResultEntitySet( player.getResults() ) );

        return playerEntity.build();
    }
}
