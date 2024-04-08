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
import pl.liga.domain.Result;
import pl.liga.domain.Season;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.AchievementEntity;
import pl.liga.infrastructure.database.entity.MatchEntity;
import pl.liga.infrastructure.database.entity.ResultEntity;
import pl.liga.infrastructure.database.entity.SeasonEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-08T18:09:34+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class MatchEntityMapperImpl implements MatchEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;
    @Autowired
    private PlayerEntityMapper playerEntityMapper;

    @Override
    public Match mapFromEntity(MatchEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Match.MatchBuilder match = Match.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, match );

        match.matchId( entity.getMatchId() );
        match.playerA( playerEntityMapper.mapFromEntity( entity.getPlayerA() ) );
        match.playerB( playerEntityMapper.mapFromEntity( entity.getPlayerB() ) );
        match.winner( playerEntityMapper.mapFromEntity( entity.getWinner() ) );
        match.loser( playerEntityMapper.mapFromEntity( entity.getLoser() ) );
        match.tournament( tournamentEntityToTournament( entity.getTournament() ) );
        match.markup( entity.getMarkup() );
        match.winnerDestinationMarkup( entity.getWinnerDestinationMarkup() );
        match.loserDestinationMarkup( entity.getLoserDestinationMarkup() );
        match.points( entity.getPoints() );
        match.active( entity.getActive() );

        return match.build();
    }

    @Override
    public Match mapFromEntityWithoutAchievementsAndResults(MatchEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Match.MatchBuilder match = Match.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, match );

        match.playerA( playerEntityMapper.mapFromEntityWithoutAchievementsAndResults( entity.getPlayerA() ) );
        match.playerB( playerEntityMapper.mapFromEntityWithoutAchievementsAndResults( entity.getPlayerB() ) );
        match.winner( playerEntityMapper.mapFromEntityWithoutAchievementsAndResults( entity.getWinner() ) );
        match.loser( playerEntityMapper.mapFromEntityWithoutAchievementsAndResults( entity.getLoser() ) );
        match.matchId( entity.getMatchId() );
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
        matchEntity.playerA( playerEntityMapper.mapToEntity( match.getPlayerA() ) );
        matchEntity.playerB( playerEntityMapper.mapToEntity( match.getPlayerB() ) );
        matchEntity.winner( playerEntityMapper.mapToEntity( match.getWinner() ) );
        matchEntity.loser( playerEntityMapper.mapToEntity( match.getLoser() ) );
        matchEntity.tournament( tournamentToTournamentEntity( match.getTournament() ) );
        matchEntity.markup( match.getMarkup() );
        matchEntity.winnerDestinationMarkup( match.getWinnerDestinationMarkup() );
        matchEntity.loserDestinationMarkup( match.getLoserDestinationMarkup() );
        matchEntity.points( match.getPoints() );
        matchEntity.active( match.getActive() );

        return matchEntity.build();
    }

    protected Result resultEntityToResult(ResultEntity resultEntity) {
        if ( resultEntity == null ) {
            return null;
        }

        Result.ResultBuilder result = Result.builder();

        cycleAvoidingMappingContext.storeMappedInstance( resultEntity, result );

        result.resultId( resultEntity.getResultId() );
        result.player( playerEntityMapper.mapFromEntity( resultEntity.getPlayer() ) );
        result.tournament( tournamentEntityToTournament( resultEntity.getTournament() ) );
        result.pointsEarned( resultEntity.getPointsEarned() );

        return result.build();
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

    protected Achievement achievementEntityToAchievement(AchievementEntity achievementEntity) {
        if ( achievementEntity == null ) {
            return null;
        }

        Achievement.AchievementBuilder achievement = Achievement.builder();

        cycleAvoidingMappingContext.storeMappedInstance( achievementEntity, achievement );

        achievement.achievementId( achievementEntity.getAchievementId() );
        achievement.player( playerEntityMapper.mapFromEntity( achievementEntity.getPlayer() ) );
        achievement.tournament( tournamentEntityToTournament( achievementEntity.getTournament() ) );
        achievement.type( achievementEntity.getType() );
        achievement.value( achievementEntity.getValue() );

        return achievement.build();
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

    protected Match matchEntityToMatch(MatchEntity matchEntity) {
        if ( matchEntity == null ) {
            return null;
        }

        Match.MatchBuilder match = Match.builder();

        cycleAvoidingMappingContext.storeMappedInstance( matchEntity, match );

        match.matchId( matchEntity.getMatchId() );
        match.playerA( playerEntityMapper.mapFromEntity( matchEntity.getPlayerA() ) );
        match.playerB( playerEntityMapper.mapFromEntity( matchEntity.getPlayerB() ) );
        match.winner( playerEntityMapper.mapFromEntity( matchEntity.getWinner() ) );
        match.loser( playerEntityMapper.mapFromEntity( matchEntity.getLoser() ) );
        match.tournament( tournamentEntityToTournament( matchEntity.getTournament() ) );
        match.markup( matchEntity.getMarkup() );
        match.winnerDestinationMarkup( matchEntity.getWinnerDestinationMarkup() );
        match.loserDestinationMarkup( matchEntity.getLoserDestinationMarkup() );
        match.points( matchEntity.getPoints() );
        match.active( matchEntity.getActive() );

        return match.build();
    }

    protected List<Match> matchEntitySetToMatchList(Set<MatchEntity> set) {
        List<Match> target = cycleAvoidingMappingContext.getMappedInstance( set, List.class );
        if ( target != null ) {
            return target;
        }

        if ( set == null ) {
            return null;
        }

        List<Match> list = new ArrayList<Match>( set.size() );
        cycleAvoidingMappingContext.storeMappedInstance( set, list );

        for ( MatchEntity matchEntity : set ) {
            list.add( matchEntityToMatch( matchEntity ) );
        }

        return list;
    }

    protected List<Tournament> tournamentEntitySetToTournamentList(Set<TournamentEntity> set) {
        List<Tournament> target = cycleAvoidingMappingContext.getMappedInstance( set, List.class );
        if ( target != null ) {
            return target;
        }

        if ( set == null ) {
            return null;
        }

        List<Tournament> list = new ArrayList<Tournament>( set.size() );
        cycleAvoidingMappingContext.storeMappedInstance( set, list );

        for ( TournamentEntity tournamentEntity : set ) {
            list.add( tournamentEntityToTournament( tournamentEntity ) );
        }

        return list;
    }

    protected Season seasonEntityToSeason(SeasonEntity seasonEntity) {
        if ( seasonEntity == null ) {
            return null;
        }

        Season.SeasonBuilder season = Season.builder();

        cycleAvoidingMappingContext.storeMappedInstance( seasonEntity, season );

        season.seasonId( seasonEntity.getSeasonId() );
        season.name( seasonEntity.getName() );
        season.startDate( seasonEntity.getStartDate() );
        season.endDate( seasonEntity.getEndDate() );
        season.toDelete( seasonEntity.getToDelete() );
        season.tournaments( tournamentEntitySetToTournamentList( seasonEntity.getTournaments() ) );
        season.rankCount( seasonEntity.getRankCount() );

        return season.build();
    }

    protected Tournament tournamentEntityToTournament(TournamentEntity tournamentEntity) {
        if ( tournamentEntity == null ) {
            return null;
        }

        Tournament.TournamentBuilder tournament = Tournament.builder();

        cycleAvoidingMappingContext.storeMappedInstance( tournamentEntity, tournament );

        tournament.tournamentId( tournamentEntity.getTournamentId() );
        tournament.date( tournamentEntity.getDate() );
        tournament.active( tournamentEntity.getActive() );
        tournament.closed( tournamentEntity.getClosed() );
        tournament.results( resultEntitySetToResultList( tournamentEntity.getResults() ) );
        tournament.achievements( achievementEntitySetToAchievementList( tournamentEntity.getAchievements() ) );
        tournament.matches( matchEntitySetToMatchList( tournamentEntity.getMatches() ) );
        tournament.size( tournamentEntity.getSize() );
        tournament.season( seasonEntityToSeason( tournamentEntity.getSeason() ) );

        return tournament.build();
    }

    protected ResultEntity resultToResultEntity(Result result) {
        if ( result == null ) {
            return null;
        }

        ResultEntity.ResultEntityBuilder resultEntity = ResultEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( result, resultEntity );

        resultEntity.resultId( result.getResultId() );
        resultEntity.player( playerEntityMapper.mapToEntity( result.getPlayer() ) );
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

    protected AchievementEntity achievementToAchievementEntity(Achievement achievement) {
        if ( achievement == null ) {
            return null;
        }

        AchievementEntity.AchievementEntityBuilder achievementEntity = AchievementEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( achievement, achievementEntity );

        achievementEntity.achievementId( achievement.getAchievementId() );
        achievementEntity.player( playerEntityMapper.mapToEntity( achievement.getPlayer() ) );
        achievementEntity.tournament( tournamentToTournamentEntity( achievement.getTournament() ) );
        achievementEntity.type( achievement.getType() );
        achievementEntity.value( achievement.getValue() );

        return achievementEntity.build();
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
}
