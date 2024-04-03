package pl.liga.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.liga.api.dto.TournamentDTO;
import pl.liga.domain.Tournament;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    default TournamentDTO map(final Tournament tournament){
        return TournamentDTO.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .closed(tournament.getClosed())
                .build();
    }

    default Tournament map(final TournamentDTO tournamentDTO){
        return Tournament.builder()
                .date(tournamentDTO.getDate())
                .closed(tournamentDTO.getClosed())
                .build();
    }
}
