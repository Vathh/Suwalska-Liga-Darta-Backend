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
    date = "2024-03-18T12:11:12+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class TournamentEntityMapperImpl implements TournamentEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;
    @Autowired
    private ResultEntityMapper resultEntityMapper;
    @Autowired
    private AchievementEntityMapper achievementEntityMapper;
    @Autowired
    private MatchEntityMapper matchEntityMapper;

    @Override
    public Tournament mapFromEntity(TournamentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Tournament.TournamentBuilder tournament = Tournament.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, tournament );

        tournament.matches( matchEntitySetToMatchList( entity.getMatches() ) );
        tournament.tournamentId( entity.getTournamentId() );
        tournament.date( entity.getDate() );
        tournament.active( entity.getActive() );
        tournament.closed( entity.getClosed() );
        tournament.results( resultEntitySetToResultList( entity.getResults() ) );
        tournament.achievements( achievementEntitySetToAchievementList( entity.getAchievements() ) );
        tournament.size( entity.getSize() );
        tournament.season( seasonEntityToSeason( entity.getSeason() ) );

        return tournament.build();
    }

    @Override
    public TournamentEntity mapToEntity(Tournament tournament) {
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

    protected List<Match> matchEntitySetToMatchList(Set<MatchEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Match> list = new ArrayList<Match>( set.size() );
        for ( MatchEntity matchEntity : set ) {
            list.add( matchEntityMapper.mapFromEntityWithoutAchievementsAndResults( matchEntity ) );
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
            list.add( resultEntityMapper.mapFromEntity( resultEntity ) );
        }

        return list;
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
            list.add( achievementEntityMapper.mapFromEntity( achievementEntity ) );
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
            list.add( mapFromEntity( tournamentEntity ) );
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
            set.add( resultEntityMapper.mapToEntity( result ) );
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
            set.add( achievementEntityMapper.mapToEntity( achievement ) );
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
            set.add( matchEntityMapper.mapToEntity( match ) );
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
            set.add( mapToEntity( tournament ) );
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
}
