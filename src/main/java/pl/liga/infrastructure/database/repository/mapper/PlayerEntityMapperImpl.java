package pl.liga.infrastructure.database.repository.mapper;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Player;
import pl.liga.infrastructure.database.entity.PlayerEntity;

@Component
public class PlayerEntityMapperImpl {

    private final AchievementEntityMapperImpl achievementEntityMapper;
    private final ResultEntityMapperImpl resultEntityMapper;

    public PlayerEntityMapperImpl(@Lazy AchievementEntityMapperImpl achievementEntityMapper,
                                  @Lazy ResultEntityMapperImpl resultEntityMapper){
        this.achievementEntityMapper = achievementEntityMapper;
        this.resultEntityMapper = resultEntityMapper;
    }

    public Player mapFromEntityWithoutResultsAndAchievements(PlayerEntity entity){
        return Player.builder()
                .playerId(entity.getPlayerId())
                .name(entity.getName())
                .build();
    }

    public Player mapFromEntityWithoutPlayerAndTournament(PlayerEntity entity){
        return Player.builder()
                .playerId(entity.getPlayerId())
                .name(entity.getName())
                .achievements(entity.getAchievements()
                        .stream()
                        .map(achievementEntityMapper::mapFromEntityWithoutPlayerAndTournament)
                        .toList())
                .results(entity.getResults()
                        .stream()
                        .map(resultEntityMapper::mapFromEntityWithoutPlayerAndTournament)
                        .toList())
                .build();
    }

    public PlayerEntity mapToEntityWithoutResultsAndAchievements(Player player){
        return PlayerEntity.builder()
                .playerId(player.getPlayerId())
                .name(player.getName())
                .build();
    }

    public PlayerEntity mapToEntity(Player player){
        return PlayerEntity.builder()
                .playerId(player.getPlayerId())
                .name(player.getName())
                .achievements(player.getAchievements()
                        .stream()
                        .map(achievementEntityMapper::mapToEntity)
                        .toList())
                .results(player.getResults()
                        .stream()
                        .map(resultEntityMapper::mapToEntity)
                        .toList())
                .build();
    }

    public Player mapFromEntity(PlayerEntity entity){
        return Player.builder()
                .playerId(entity.getPlayerId())
                .name(entity.getName())
                .achievements(entity.getAchievements()
                        .stream()
                        .map(achievementEntityMapper::mapFromEntity)
                        .toList())
                .results(entity.getResults()
                        .stream()
                        .map(resultEntityMapper::mapFromEntity)
                        .toList())
                .build();
    }
}
