package pl.liga.infrastructure.database.repository.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.liga.domain.SchemaMatch;
import pl.liga.infrastructure.database.entity.SchemaMatchEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T12:11:11+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class SchemaMatchEntityMapperImpl implements SchemaMatchEntityMapper {

    @Autowired
    private CycleAvoidingMappingContext cycleAvoidingMappingContext;

    @Override
    public SchemaMatch mapFromEntity(SchemaMatchEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SchemaMatch.SchemaMatchBuilder schemaMatch = SchemaMatch.builder();

        cycleAvoidingMappingContext.storeMappedInstance( entity, schemaMatch );

        schemaMatch.schemaMatchId( entity.getSchemaMatchId() );
        schemaMatch.playerANumber( entity.getPlayerANumber() );
        schemaMatch.playerBNumber( entity.getPlayerBNumber() );
        schemaMatch.markup( entity.getMarkup() );
        schemaMatch.winnerDestinationMarkup( entity.getWinnerDestinationMarkup() );
        schemaMatch.loserDestinationMarkup( entity.getLoserDestinationMarkup() );
        schemaMatch.points( entity.getPoints() );

        return schemaMatch.build();
    }

    @Override
    public SchemaMatchEntity mapToEntity(SchemaMatch schemaMatch) {
        if ( schemaMatch == null ) {
            return null;
        }

        SchemaMatchEntity.SchemaMatchEntityBuilder schemaMatchEntity = SchemaMatchEntity.builder();

        cycleAvoidingMappingContext.storeMappedInstance( schemaMatch, schemaMatchEntity );

        schemaMatchEntity.schemaMatchId( schemaMatch.getSchemaMatchId() );
        schemaMatchEntity.playerANumber( schemaMatch.getPlayerANumber() );
        schemaMatchEntity.playerBNumber( schemaMatch.getPlayerBNumber() );
        schemaMatchEntity.markup( schemaMatch.getMarkup() );
        schemaMatchEntity.winnerDestinationMarkup( schemaMatch.getWinnerDestinationMarkup() );
        schemaMatchEntity.loserDestinationMarkup( schemaMatch.getLoserDestinationMarkup() );
        schemaMatchEntity.points( schemaMatch.getPoints() );

        return schemaMatchEntity.build();
    }
}
