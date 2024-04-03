package pl.liga.api.dto.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.liga.api.dto.TournamentDTO;
import pl.liga.api.dto.TournamentWithResultsAndAchievementsDTO;
import pl.liga.api.dto.TournamentWithResultsDTO;
import pl.liga.api.dto.TournamentWithoutResultsDTO;
import pl.liga.domain.Tournament;

@Component
@AllArgsConstructor
public class TournamentMapperImpl {

    private final ResultMapperImpl resultMapper;
    private final MatchMapperImpl matchMapperImpl;
    private final AchievementMapper achievementMapper;

    public TournamentWithResultsDTO mapWithResults(Tournament tournament){
        return TournamentWithResultsDTO.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .active(tournament.getActive())
                .closed(tournament.getClosed())
                .results(tournament.getResults()
                                    .stream()
                                    .map(resultMapper::map)
                                    .toList())
                .size(tournament.getSize())
                .build();
    }

    public TournamentWithResultsAndAchievementsDTO mapWithResultsAndAchievements(Tournament tournament){
        return TournamentWithResultsAndAchievementsDTO.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .active(tournament.getActive())
                .closed(tournament.getClosed())
                .results(tournament.getResults()
                        .stream()
                        .map(resultMapper::map)
                        .toList())
                .achievements(tournament.getAchievements()
                        .stream()
                        .map(achievementMapper::map)
                        .toList())
                .size(tournament.getSize())
                .build();
    }

    public TournamentWithoutResultsDTO mapWithoutResults(Tournament tournament){
        return TournamentWithoutResultsDTO.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .active(tournament.getActive())
                .closed(tournament.getClosed())
                .seasonName(tournament.getSeason().getName())
                .size(tournament.getSize())
                .build();
    }

    public TournamentDTO mapToDTO(Tournament tournament){
        return TournamentDTO.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .matches(tournament.getMatches().stream().map(matchMapperImpl::map).toList())
                .closed(tournament.getClosed())
                .active(tournament.getActive())
                .size(tournament.getSize())
                .build();
    }

    public Tournament mapWithResults(TournamentWithResultsDTO tournamentWithResultsDTO){
        return Tournament.builder()
                .date(tournamentWithResultsDTO.getDate())
                .closed(tournamentWithResultsDTO.getClosed())
                .active(tournamentWithResultsDTO.getActive())
                .size(tournamentWithResultsDTO.getSize())
                .build();
    }
}
