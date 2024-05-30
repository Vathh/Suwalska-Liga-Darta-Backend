package pl.liga.api.dto.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.liga.api.dto.PlayerDTO;
import pl.liga.domain.Player;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T15:19:43+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public Player map(PlayerDTO playerDTO) {
        if ( playerDTO == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        player.playerId( playerDTO.getPlayerId() );
        player.name( playerDTO.getName() );

        return player.build();
    }
}
