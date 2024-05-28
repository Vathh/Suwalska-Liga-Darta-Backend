package pl.liga.infrastructure.database.repository.mapper;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Achievement;
import pl.liga.infrastructure.database.entity.AchievementEntity;

@Component
public class AchievementEntityMapperImpl {

    @Lazy
    private final PlayerEntityMapperImpl playerEntityMapper;
    private final TournamentEntityMapperImpl tournamentEntityMapper;

    public AchievementEntityMapperImpl(@Lazy PlayerEntityMapperImpl playerEntityMapper,
                                       @Lazy TournamentEntityMapperImpl tournamentEntityMapper){
        this.playerEntityMapper = playerEntityMapper;
        this.tournamentEntityMapper = tournamentEntityMapper;
    }

    public Achievement mapFromEntityWithoutTournament(AchievementEntity entity){
        return Achievement.builder()
                .achievementId(entity.getAchievementId())
                .player(playerEntityMapper.mapFromEntity(entity.getPlayer()))
                .type(entity.getType())
                .value(entity.getValue())
                .build();
    }


    public Achievement mapFromEntityWithoutPlayerAndTournament(AchievementEntity entity){
        return Achievement.builder()
                .achievementId(entity.getAchievementId())
                .type(entity.getType())
                .value(entity.getValue())
                .build();
    }

    public AchievementEntity mapToEntityWithoutResultsAndAchievements(Achievement achievement){
        return AchievementEntity.builder()
                .achievementId(achievement.getAchievementId())
                .player(playerEntityMapper.mapToEntityWithoutResultsAndAchievements(achievement.getPlayer()))
                .tournament(tournamentEntityMapper.mapToEntityWithoutResultsAchievementsAndMatches(achievement.getTournament()))
                .type(achievement.getType())
                .value(achievement.getValue())
                .build();
    }

    public Achievement mapFromEntity(AchievementEntity entity){
        return Achievement.builder()
                .achievementId(entity.getAchievementId())
                .player(playerEntityMapper.mapFromEntity(entity.getPlayer()))
                .tournament(tournamentEntityMapper.mapFromEntity(entity.getTournament()))
                .type(entity.getType())
                .value(entity.getValue())
                .build();
    }

    public AchievementEntity mapToEntity(Achievement achievement){
        return AchievementEntity.builder()
                .achievementId(achievement.getAchievementId())
                .player(playerEntityMapper.mapToEntity(achievement.getPlayer()))
                .tournament(tournamentEntityMapper.mapToEntity(achievement.getTournament()))
                .type(achievement.getType())
                .value(achievement.getValue())
                .build();
    }
}
