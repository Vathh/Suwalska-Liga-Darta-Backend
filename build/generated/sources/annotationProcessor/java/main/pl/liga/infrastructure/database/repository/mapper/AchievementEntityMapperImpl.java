package pl.liga.infrastructure.database.repository.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.liga.domain.Achievement;
import pl.liga.infrastructure.database.entity.AchievementEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T09:41:34+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class AchievementEntityMapperImpl implements AchievementEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;
    @Autowired
    private PlayerEntityMapper playerEntityMapper;
    @Autowired
    private TournamentEntityMapper tournamentEntityMapper;

    @Override
    public Achievement mapFromEntityWithoutTournament(AchievementEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Achievement.AchievementBuilder achievement = Achievement.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, achievement );

        achievement.player( playerEntityMapper.mapFromEntity( entity.getPlayer() ) );
        achievement.achievementId( entity.getAchievementId() );
        achievement.type( entity.getType() );
        achievement.value( entity.getValue() );

        return achievement.build();
    }

    @Override
    public Achievement mapFromEntityWithoutPlayerAndTournament(AchievementEntity entity) {
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
    public AchievementEntity mapToEntityWithoutResultsAndAchievements(Achievement achievement) {
        if ( achievement == null ) {
            return null;
        }

        AchievementEntity.AchievementEntityBuilder achievementEntity = AchievementEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( achievement, achievementEntity );

        achievementEntity.player( playerEntityMapper.mapToEntityWithoutResultsAndAchievements( achievement.getPlayer() ) );
        achievementEntity.tournament( tournamentEntityMapper.mapToEntityWithoutResultsAchievementsAndMatches( achievement.getTournament() ) );
        achievementEntity.achievementId( achievement.getAchievementId() );
        achievementEntity.type( achievement.getType() );
        achievementEntity.value( achievement.getValue() );

        return achievementEntity.build();
    }

    @Override
    public Achievement mapFromEntity(AchievementEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Achievement.AchievementBuilder achievement = Achievement.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, achievement );

        achievement.player( playerEntityMapper.mapFromEntity( entity.getPlayer() ) );
        achievement.tournament( tournamentEntityMapper.mapFromEntity( entity.getTournament() ) );
        achievement.achievementId( entity.getAchievementId() );
        achievement.type( entity.getType() );
        achievement.value( entity.getValue() );

        return achievement.build();
    }

    @Override
    public AchievementEntity mapToEntity(Achievement achievement) {
        if ( achievement == null ) {
            return null;
        }

        AchievementEntity.AchievementEntityBuilder achievementEntity = AchievementEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( achievement, achievementEntity );

        achievementEntity.player( playerEntityMapper.mapToEntity( achievement.getPlayer() ) );
        achievementEntity.tournament( tournamentEntityMapper.mapToEntity( achievement.getTournament() ) );
        achievementEntity.achievementId( achievement.getAchievementId() );
        achievementEntity.type( achievement.getType() );
        achievementEntity.value( achievement.getValue() );

        return achievementEntity.build();
    }
}
