package pl.liga.infrastructure.database.repository.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.liga.domain.Season;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.SeasonEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T09:41:34+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class SeasonEntityMapperImpl implements SeasonEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;
    @Autowired
    private TournamentEntityMapper tournamentEntityMapper;

    @Override
    public Season mapFromEntityWithoutMatchesAndSeason(SeasonEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Season.SeasonBuilder season = Season.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, season );

        season.tournaments( tournamentEntityListToTournamentList( entity.getTournaments() ) );
        season.seasonId( entity.getSeasonId() );
        season.name( entity.getName() );
        season.startDate( entity.getStartDate() );
        season.endDate( entity.getEndDate() );
        season.toDelete( entity.getToDelete() );
        season.rankCount( entity.getRankCount() );

        return season.build();
    }

    @Override
    public SeasonEntity mapToEntityWithoutResultsAchievementsAndMatches(Season season) {
        if ( season == null ) {
            return null;
        }

        SeasonEntity.SeasonEntityBuilder seasonEntity = SeasonEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( season, seasonEntity );

        seasonEntity.tournaments( tournamentListToTournamentEntityList( season.getTournaments() ) );
        seasonEntity.seasonId( season.getSeasonId() );
        seasonEntity.name( season.getName() );
        seasonEntity.startDate( season.getStartDate() );
        seasonEntity.endDate( season.getEndDate() );
        seasonEntity.toDelete( season.getToDelete() );
        seasonEntity.rankCount( season.getRankCount() );

        return seasonEntity.build();
    }

    @Override
    public List<Tournament> mapTournamentsWithoutMatchesAndSeasonFromEntites(List<TournamentEntity> tournaments) {
        if ( tournaments == null ) {
            return null;
        }

        List<Tournament> list = new ArrayList<Tournament>( tournaments.size() );
        for ( TournamentEntity tournamentEntity : tournaments ) {
            list.add( tournamentEntityMapper.mapFromEntityWithoutMatchesAndSeason( tournamentEntity ) );
        }

        return list;
    }

    @Override
    public List<TournamentEntity> mapTournamentsWithoutResultsAchievementsAndMatchesToEntities(List<Tournament> tournaments) {
        if ( tournaments == null ) {
            return null;
        }

        List<TournamentEntity> list = new ArrayList<TournamentEntity>( tournaments.size() );
        for ( Tournament tournament : tournaments ) {
            list.add( tournamentEntityMapper.mapToEntityWithoutResultsAchievementsAndMatches( tournament ) );
        }

        return list;
    }

    @Override
    public List<Tournament> mapTournamentsFullFromEntities(List<TournamentEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Tournament> list = new ArrayList<Tournament>( entities.size() );
        for ( TournamentEntity tournamentEntity : entities ) {
            list.add( tournamentEntityMapper.mapFromEntity( tournamentEntity ) );
        }

        return list;
    }

    @Override
    public List<TournamentEntity> mapTournamentsFullToEntities(List<Tournament> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TournamentEntity> list = new ArrayList<TournamentEntity>( entities.size() );
        for ( Tournament tournament : entities ) {
            list.add( tournamentEntityMapper.mapToEntity( tournament ) );
        }

        return list;
    }

    @Override
    public Season mapFromEntity(SeasonEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Season.SeasonBuilder season = Season.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, season );

        season.tournaments( tournamentEntityListToTournamentList1( entity.getTournaments() ) );
        season.seasonId( entity.getSeasonId() );
        season.name( entity.getName() );
        season.startDate( entity.getStartDate() );
        season.endDate( entity.getEndDate() );
        season.toDelete( entity.getToDelete() );
        season.rankCount( entity.getRankCount() );

        return season.build();
    }

    @Override
    public SeasonEntity mapToEntity(Season season) {
        if ( season == null ) {
            return null;
        }

        SeasonEntity.SeasonEntityBuilder seasonEntity = SeasonEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( season, seasonEntity );

        seasonEntity.tournaments( tournamentListToTournamentEntityList1( season.getTournaments() ) );
        seasonEntity.seasonId( season.getSeasonId() );
        seasonEntity.name( season.getName() );
        seasonEntity.startDate( season.getStartDate() );
        seasonEntity.endDate( season.getEndDate() );
        seasonEntity.toDelete( season.getToDelete() );
        seasonEntity.rankCount( season.getRankCount() );

        return seasonEntity.build();
    }

    protected List<Tournament> tournamentEntityListToTournamentList(List<TournamentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Tournament> list1 = new ArrayList<Tournament>( list.size() );
        for ( TournamentEntity tournamentEntity : list ) {
            list1.add( tournamentEntityMapper.mapFromEntityWithoutMatchesAndSeason( tournamentEntity ) );
        }

        return list1;
    }

    protected List<TournamentEntity> tournamentListToTournamentEntityList(List<Tournament> list) {
        if ( list == null ) {
            return null;
        }

        List<TournamentEntity> list1 = new ArrayList<TournamentEntity>( list.size() );
        for ( Tournament tournament : list ) {
            list1.add( tournamentEntityMapper.mapToEntityWithoutResultsAchievementsAndMatches( tournament ) );
        }

        return list1;
    }

    protected List<Tournament> tournamentEntityListToTournamentList1(List<TournamentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Tournament> list1 = new ArrayList<Tournament>( list.size() );
        for ( TournamentEntity tournamentEntity : list ) {
            list1.add( tournamentEntityMapper.mapFromEntity( tournamentEntity ) );
        }

        return list1;
    }

    protected List<TournamentEntity> tournamentListToTournamentEntityList1(List<Tournament> list) {
        if ( list == null ) {
            return null;
        }

        List<TournamentEntity> list1 = new ArrayList<TournamentEntity>( list.size() );
        for ( Tournament tournament : list ) {
            list1.add( tournamentEntityMapper.mapToEntity( tournament ) );
        }

        return list1;
    }
}
