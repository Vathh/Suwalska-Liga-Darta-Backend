package pl.liga.infrastructure.database.repository.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.liga.domain.Result;
import pl.liga.infrastructure.database.entity.ResultEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T09:41:34+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class ResultEntityMapperImpl implements ResultEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;
    @Autowired
    private PlayerEntityMapper playerEntityMapper;
    @Autowired
    private TournamentEntityMapper tournamentEntityMapper;

    @Override
    public Result mapFromEntityWithoutTournament(ResultEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Result.ResultBuilder result = Result.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, result );

        result.player( playerEntityMapper.mapFromEntityWithoutResultsAndAchievements( entity.getPlayer() ) );
        result.resultId( entity.getResultId() );
        result.pointsEarned( entity.getPointsEarned() );

        return result.build();
    }

    @Override
    public Result mapFromEntityWithoutPlayerAndTournament(ResultEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Result.ResultBuilder result = Result.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, result );

        result.resultId( entity.getResultId() );
        result.pointsEarned( entity.getPointsEarned() );

        return result.build();
    }

    @Override
    public Result mapFromEntity(ResultEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Result.ResultBuilder result = Result.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, result );

        result.player( playerEntityMapper.mapFromEntity( entity.getPlayer() ) );
        result.tournament( tournamentEntityMapper.mapFromEntity( entity.getTournament() ) );
        result.resultId( entity.getResultId() );
        result.pointsEarned( entity.getPointsEarned() );

        return result.build();
    }

    @Override
    public ResultEntity mapToEntity(Result result) {
        if ( result == null ) {
            return null;
        }

        ResultEntity.ResultEntityBuilder resultEntity = ResultEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( result, resultEntity );

        resultEntity.player( playerEntityMapper.mapToEntity( result.getPlayer() ) );
        resultEntity.tournament( tournamentEntityMapper.mapToEntity( result.getTournament() ) );
        resultEntity.resultId( result.getResultId() );
        resultEntity.pointsEarned( result.getPointsEarned() );

        return resultEntity.build();
    }
}
