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
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.AchievementEntity;
import pl.liga.infrastructure.database.entity.MatchEntity;
import pl.liga.infrastructure.database.entity.ResultEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T09:41:34+0200",
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
    @Autowired
    private SeasonEntityMapper seasonEntityMapper;

    @Override
    public Tournament mapFromEntityWithoutMatchesAndSeason(TournamentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Tournament.TournamentBuilder tournament = Tournament.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, tournament );

        tournament.results( resultEntitySetToResultList( entity.getResults() ) );
        tournament.achievements( achievementEntitySetToAchievementList( entity.getAchievements() ) );
        tournament.tournamentId( entity.getTournamentId() );
        tournament.date( entity.getDate() );
        tournament.active( entity.getActive() );
        tournament.closed( entity.getClosed() );
        tournament.size( entity.getSize() );

        return tournament.build();
    }

    @Override
    public TournamentEntity mapToEntityWithoutResultsAchievementsAndMatches(Tournament tournament) {
        if ( tournament == null ) {
            return null;
        }

        TournamentEntity.TournamentEntityBuilder tournamentEntity = TournamentEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( tournament, tournamentEntity );

        tournamentEntity.season( seasonEntityMapper.mapToEntity( tournament.getSeason() ) );
        tournamentEntity.tournamentId( tournament.getTournamentId() );
        tournamentEntity.date( tournament.getDate() );
        tournamentEntity.size( tournament.getSize() );
        tournamentEntity.active( tournament.getActive() );
        tournamentEntity.closed( tournament.getClosed() );

        return tournamentEntity.build();
    }

    @Override
    public Tournament mapIdOnlyFromEntity(TournamentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Tournament.TournamentBuilder tournament = Tournament.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, tournament );

        tournament.tournamentId( entity.getTournamentId() );

        return tournament.build();
    }

    @Override
    public TournamentEntity mapIdOnlyFromEntity(Tournament tournament) {
        if ( tournament == null ) {
            return null;
        }

        TournamentEntity.TournamentEntityBuilder tournamentEntity = TournamentEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( tournament, tournamentEntity );

        tournamentEntity.tournamentId( tournament.getTournamentId() );

        return tournamentEntity.build();
    }

    @Override
    public List<Result> mapResultsFromEntities(List<ResultEntity> results) {
        if ( results == null ) {
            return null;
        }

        List<Result> list = new ArrayList<Result>( results.size() );
        for ( ResultEntity resultEntity : results ) {
            list.add( resultEntityMapper.mapFromEntityWithoutTournament( resultEntity ) );
        }

        return list;
    }

    @Override
    public List<Achievement> mapAchievementsFromEntites(List<AchievementEntity> achievements) {
        if ( achievements == null ) {
            return null;
        }

        List<Achievement> list = new ArrayList<Achievement>( achievements.size() );
        for ( AchievementEntity achievementEntity : achievements ) {
            list.add( achievementEntityMapper.mapFromEntityWithoutTournament( achievementEntity ) );
        }

        return list;
    }

    @Override
    public Tournament mapFromEntity(TournamentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Tournament.TournamentBuilder tournament = Tournament.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, tournament );

        tournament.matches( matchEntitySetToMatchList( entity.getMatches() ) );
        tournament.season( seasonEntityMapper.mapFromEntity( entity.getSeason() ) );
        tournament.results( resultEntitySetToResultList1( entity.getResults() ) );
        tournament.achievements( achievementEntitySetToAchievementList1( entity.getAchievements() ) );
        tournament.tournamentId( entity.getTournamentId() );
        tournament.date( entity.getDate() );
        tournament.active( entity.getActive() );
        tournament.closed( entity.getClosed() );
        tournament.size( entity.getSize() );

        return tournament.build();
    }

    @Override
    public TournamentEntity mapToEntity(Tournament tournament) {
        if ( tournament == null ) {
            return null;
        }

        TournamentEntity.TournamentEntityBuilder tournamentEntity = TournamentEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( tournament, tournamentEntity );

        tournamentEntity.matches( matchListToMatchEntitySet( tournament.getMatches() ) );
        tournamentEntity.season( seasonEntityMapper.mapToEntity( tournament.getSeason() ) );
        tournamentEntity.results( resultListToResultEntitySet( tournament.getResults() ) );
        tournamentEntity.achievements( achievementListToAchievementEntitySet( tournament.getAchievements() ) );
        tournamentEntity.tournamentId( tournament.getTournamentId() );
        tournamentEntity.date( tournament.getDate() );
        tournamentEntity.size( tournament.getSize() );
        tournamentEntity.active( tournament.getActive() );
        tournamentEntity.closed( tournament.getClosed() );

        return tournamentEntity.build();
    }

    protected List<Result> resultEntitySetToResultList(Set<ResultEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Result> list = new ArrayList<Result>( set.size() );
        for ( ResultEntity resultEntity : set ) {
            list.add( resultEntityMapper.mapFromEntityWithoutTournament( resultEntity ) );
        }

        return list;
    }

    protected List<Achievement> achievementEntitySetToAchievementList(Set<AchievementEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Achievement> list = new ArrayList<Achievement>( set.size() );
        for ( AchievementEntity achievementEntity : set ) {
            list.add( achievementEntityMapper.mapFromEntityWithoutTournament( achievementEntity ) );
        }

        return list;
    }

    protected List<Match> matchEntitySetToMatchList(Set<MatchEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Match> list = new ArrayList<Match>( set.size() );
        for ( MatchEntity matchEntity : set ) {
            list.add( matchEntityMapper.mapFromEntity( matchEntity ) );
        }

        return list;
    }

    protected List<Result> resultEntitySetToResultList1(Set<ResultEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Result> list = new ArrayList<Result>( set.size() );
        for ( ResultEntity resultEntity : set ) {
            list.add( resultEntityMapper.mapFromEntity( resultEntity ) );
        }

        return list;
    }

    protected List<Achievement> achievementEntitySetToAchievementList1(Set<AchievementEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Achievement> list = new ArrayList<Achievement>( set.size() );
        for ( AchievementEntity achievementEntity : set ) {
            list.add( achievementEntityMapper.mapFromEntity( achievementEntity ) );
        }

        return list;
    }

    protected Set<MatchEntity> matchListToMatchEntitySet(List<Match> list) {
        if ( list == null ) {
            return null;
        }

        Set<MatchEntity> set = new LinkedHashSet<MatchEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( Match match : list ) {
            set.add( matchEntityMapper.mapToEntity( match ) );
        }

        return set;
    }

    protected Set<ResultEntity> resultListToResultEntitySet(List<Result> list) {
        if ( list == null ) {
            return null;
        }

        Set<ResultEntity> set = new LinkedHashSet<ResultEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( Result result : list ) {
            set.add( resultEntityMapper.mapToEntity( result ) );
        }

        return set;
    }

    protected Set<AchievementEntity> achievementListToAchievementEntitySet(List<Achievement> list) {
        if ( list == null ) {
            return null;
        }

        Set<AchievementEntity> set = new LinkedHashSet<AchievementEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( Achievement achievement : list ) {
            set.add( achievementEntityMapper.mapToEntity( achievement ) );
        }

        return set;
    }
}
