package pl.liga.infrastructure.database.repository.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.liga.domain.Season;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.SeasonEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-07T19:12:56+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class SeasonEntityMapperImpl implements SeasonEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;
    @Autowired
    private TournamentEntityMapper tournamentEntityMapper;

    @Override
    public Season mapFromEntity(SeasonEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Season.SeasonBuilder season = Season.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, season );

        season.seasonId( entity.getSeasonId() );
        season.name( entity.getName() );
        season.startDate( entity.getStartDate() );
        season.endDate( entity.getEndDate() );
        season.toDelete( entity.getToDelete() );
        season.tournaments( tournamentEntitySetToTournamentList( entity.getTournaments() ) );
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

        seasonEntity.seasonId( season.getSeasonId() );
        seasonEntity.name( season.getName() );
        seasonEntity.startDate( season.getStartDate() );
        seasonEntity.endDate( season.getEndDate() );
        seasonEntity.toDelete( season.getToDelete() );
        seasonEntity.tournaments( tournamentListToTournamentEntitySet( season.getTournaments() ) );
        seasonEntity.rankCount( season.getRankCount() );

        return seasonEntity.build();
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
            list.add( tournamentEntityMapper.mapFromEntity( tournamentEntity ) );
        }

        return list;
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
            set.add( tournamentEntityMapper.mapToEntity( tournament ) );
        }

        return set;
    }
}
