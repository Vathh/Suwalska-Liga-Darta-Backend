package pl.liga.infrastructure.database.repository.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.liga.domain.Achievement;
import pl.liga.domain.Player;
import pl.liga.domain.Result;
import pl.liga.infrastructure.database.entity.AchievementEntity;
import pl.liga.infrastructure.database.entity.PlayerEntity;
import pl.liga.infrastructure.database.entity.ResultEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T09:41:34+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class PlayerEntityMapperImpl implements PlayerEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;
    @Autowired
    private ResultEntityMapper resultEntityMapper;
    @Autowired
    private AchievementEntityMapper achievementEntityMapper;

    @Override
    public Player mapFromEntityWithoutResultsAndAchievements(PlayerEntity entity) {
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
    public Player mapFromEntityWithoutPlayerAndTournament(PlayerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, player );

        player.achievements( achievementEntitySetToAchievementList( entity.getAchievements() ) );
        player.results( resultEntitySetToResultList( entity.getResults() ) );
        player.playerId( entity.getPlayerId() );
        player.name( entity.getName() );

        return player.build();
    }

    @Override
    public PlayerEntity mapToEntityWithoutResultsAndAchievements(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerEntity.PlayerEntityBuilder playerEntity = PlayerEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( player, playerEntity );

        playerEntity.playerId( player.getPlayerId() );
        playerEntity.name( player.getName() );

        return playerEntity.build();
    }

    @Override
    public List<Achievement> mapAchievementsWithoutPlayerAndTournament(List<AchievementEntity> achievements) {
        if ( achievements == null ) {
            return null;
        }

        List<Achievement> list = new ArrayList<Achievement>( achievements.size() );
        for ( AchievementEntity achievementEntity : achievements ) {
            list.add( achievementEntityMapper.mapFromEntityWithoutPlayerAndTournament( achievementEntity ) );
        }

        return list;
    }

    @Override
    public List<Result> mapResultsWithoutPlayerAndTournament(List<ResultEntity> results) {
        if ( results == null ) {
            return null;
        }

        List<Result> list = new ArrayList<Result>( results.size() );
        for ( ResultEntity resultEntity : results ) {
            list.add( resultEntityMapper.mapFromEntityWithoutPlayerAndTournament( resultEntity ) );
        }

        return list;
    }

    @Override
    public PlayerEntity mapToEntity(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerEntity.PlayerEntityBuilder playerEntity = PlayerEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( player, playerEntity );

        playerEntity.achievements( achievementListToAchievementEntitySet( player.getAchievements() ) );
        playerEntity.results( resultListToResultEntitySet( player.getResults() ) );
        playerEntity.playerId( player.getPlayerId() );
        playerEntity.name( player.getName() );

        return playerEntity.build();
    }

    @Override
    public Player mapFromEntity(PlayerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, player );

        player.achievements( achievementEntitySetToAchievementList1( entity.getAchievements() ) );
        player.results( resultEntitySetToResultList1( entity.getResults() ) );
        player.playerId( entity.getPlayerId() );
        player.name( entity.getName() );

        return player.build();
    }

    protected List<Achievement> achievementEntitySetToAchievementList(Set<AchievementEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Achievement> list = new ArrayList<Achievement>( set.size() );
        for ( AchievementEntity achievementEntity : set ) {
            list.add( achievementEntityMapper.mapFromEntityWithoutPlayerAndTournament( achievementEntity ) );
        }

        return list;
    }

    protected List<Result> resultEntitySetToResultList(Set<ResultEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Result> list = new ArrayList<Result>( set.size() );
        for ( ResultEntity resultEntity : set ) {
            list.add( resultEntityMapper.mapFromEntityWithoutPlayerAndTournament( resultEntity ) );
        }

        return list;
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
}
