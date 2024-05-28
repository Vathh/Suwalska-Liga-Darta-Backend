package pl.liga.infrastructure.database.repository.mapper;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Result;
import pl.liga.infrastructure.database.entity.ResultEntity;

@Component
public class ResultEntityMapperImpl {

    private final PlayerEntityMapperImpl playerEntityMapper;
    private final TournamentEntityMapperImpl tournamentEntityMapper;

    public ResultEntityMapperImpl(@Lazy PlayerEntityMapperImpl playerEntityMapper,
                                  @Lazy TournamentEntityMapperImpl tournamentEntityMapper){
        this.playerEntityMapper = playerEntityMapper;
        this.tournamentEntityMapper = tournamentEntityMapper;
    }

    public Result mapFromEntityWithoutTournament(ResultEntity entity){
        return Result.builder()
                .resultId(entity.getResultId())
                .player(playerEntityMapper.mapFromEntityWithoutResultsAndAchievements(entity.getPlayer()))
                .pointsEarned(entity.getPointsEarned())
                .build();
    }

    public Result mapFromEntityWithoutPlayerAndTournament(ResultEntity entity){
        return Result.builder()
                .resultId(entity.getResultId())
                .pointsEarned(entity.getPointsEarned())
                .build();
    }

    public Result mapFromEntity(ResultEntity entity){
        return Result.builder()
                .resultId(entity.getResultId())
                .player(playerEntityMapper.mapFromEntity(entity.getPlayer()))
                .tournament(tournamentEntityMapper.mapFromEntity(entity.getTournament()))
                .pointsEarned(entity.getPointsEarned())
                .build();
    }

    public ResultEntity mapToEntity(Result result){
        return ResultEntity.builder()
                .resultId(result.getResultId())
                .player(playerEntityMapper.mapToEntity(result.getPlayer()))
                .tournament(tournamentEntityMapper.mapToEntity(result.getTournament()))
                .pointsEarned(result.getPointsEarned())
                .build();
    }
}
