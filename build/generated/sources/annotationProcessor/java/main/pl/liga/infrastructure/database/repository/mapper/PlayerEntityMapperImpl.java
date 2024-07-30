package pl.liga.infrastructure.database.repository.mapper;

import java.util.ArrayList;
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
    date = "2024-07-30T20:10:17+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class PlayerEntityMapperImpl implements PlayerEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;

    @Override
    public PlayerEntity mapToEntity(Player player) {
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

    @Override
    public Player mapFromEntity(PlayerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, player );

        player.playerId( entity.getPlayerId() );
        player.name( entity.getName() );
        player.achievements( achievementEntitySetToAchievementList( entity.getAchievements() ) );
        player.results( resultEntitySetToResultList( entity.getResults() ) );

        return player.build();
    }

    @Override
    public Player mapFromEntityWithoutResults(PlayerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, player );

        player.playerId( entity.getPlayerId() );
        player.name( entity.getName() );
        player.achievements( achievementEntitySetToAchievementList( entity.getAchievements() ) );

        return player.build();
    }

    @Override
    public Player mapFromEntityWithoutAchievementsAndResults(PlayerEntity entity) {
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
    public Achievement achievementEntityToAchievement(AchievementEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Achievement.AchievementBuilder achievement = Achievement.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, achievement );

        achievement.achievementId( entity.getAchievementId() );
        achievement.type( entity.getType() );
        achievement.value( entity.getValue() );

        return achievement.build();
    }

    @Override
    public Result resultEntityToResult(ResultEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Result.ResultBuilder result = Result.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, result );

        result.resultId( entity.getResultId() );
        result.pointsEarned( entity.getPointsEarned() );

        return result.build();
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
        tournament.size( entity.getSize() );
        tournament.active( entity.getActive() );
        tournament.closed( entity.getClosed() );

        return tournament.build();
    }

    protected ResultEntity resultToResultEntity(Result result) {
        if ( result == null ) {
            return null;
        }

        ResultEntity.ResultEntityBuilder resultEntity = ResultEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( result, resultEntity );

        resultEntity.resultId( result.getResultId() );
        resultEntity.player( mapToEntity( result.getPlayer() ) );
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

    protected MatchEntity matchToMatchEntity(Match match) {
        if ( match == null ) {
            return null;
        }

        MatchEntity.MatchEntityBuilder matchEntity = MatchEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( match, matchEntity );

        matchEntity.matchId( match.getMatchId() );
        matchEntity.playerA( mapToEntity( match.getPlayerA() ) );
        matchEntity.playerB( mapToEntity( match.getPlayerB() ) );
        matchEntity.winner( mapToEntity( match.getWinner() ) );
        matchEntity.loser( mapToEntity( match.getLoser() ) );
        matchEntity.tournament( tournamentToTournamentEntity( match.getTournament() ) );
        matchEntity.markup( match.getMarkup() );
        matchEntity.winnerDestinationMarkup( match.getWinnerDestinationMarkup() );
        matchEntity.loserDestinationMarkup( match.getLoserDestinationMarkup() );
        matchEntity.points( match.getPoints() );
        matchEntity.active( match.getActive() );

        return matchEntity.build();
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
            set.add( matchToMatchEntity( match ) );
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
        achievementEntity.player( mapToEntity( achievement.getPlayer() ) );
        achievementEntity.tournament( tournamentToTournamentEntity( achievement.getTournament() ) );
        achievementEntity.type( achievement.getType() );
        achievementEntity.value( achievement.getValue() );

        return achievementEntity.build();
    }

    protected List<Achievement> achievementEntitySetToAchievementList(Set<AchievementEntity> set) {
        List<Achievement> target = cycleAvoidingMappingContext.getMappedInstance( set, List.class );
        if ( target != null ) {
            return target;
        }

        if ( set == null ) {
            return null;
        }

        List<Achievement> list = new ArrayList<Achievement>( set.size() );
        cycleAvoidingMappingContext.storeMappedInstance( set, list );

        for ( AchievementEntity achievementEntity : set ) {
            list.add( achievementEntityToAchievement( achievementEntity ) );
        }

        return list;
    }

    protected List<Result> resultEntitySetToResultList(Set<ResultEntity> set) {
        List<Result> target = cycleAvoidingMappingContext.getMappedInstance( set, List.class );
        if ( target != null ) {
            return target;
        }

        if ( set == null ) {
            return null;
        }

        List<Result> list = new ArrayList<Result>( set.size() );
        cycleAvoidingMappingContext.storeMappedInstance( set, list );

        for ( ResultEntity resultEntity : set ) {
            list.add( resultEntityToResult( resultEntity ) );
        }

        return list;
    }
}
