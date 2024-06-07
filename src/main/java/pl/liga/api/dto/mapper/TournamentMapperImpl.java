package pl.liga.api.dto.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.liga.api.dto.TournamentDTO;
import pl.liga.api.dto.TournamentWithoutAchievementsMatchesDTO;
import pl.liga.api.dto.TournamentWithoutAchievementsResultsMatchesDTO;
import pl.liga.api.dto.TournamentWithoutMatchesDTO;
import pl.liga.domain.Tournament;

@Component
@AllArgsConstructor
public class TournamentMapperImpl {

    private final ResultMapperImpl resultMapper;
    private final MatchMapperImpl matchMapperImpl;
    private final AchievementMapper achievementMapper;

    public TournamentWithoutAchievementsMatchesDTO mapWithResults(Tournament tournament){
        return TournamentWithoutAchievementsMatchesDTO.builder()
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

    public TournamentWithoutMatchesDTO mapWithResultsAndAchievements(Tournament tournament){
        return TournamentWithoutMatchesDTO.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .size(tournament.getSize())
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
                .build();
    }

    public TournamentWithoutAchievementsResultsMatchesDTO mapWithoutResults(Tournament tournament){
        return TournamentWithoutAchievementsResultsMatchesDTO.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .size(tournament.getSize())
                .active(tournament.getActive())
                .closed(tournament.getClosed())
                .seasonName(tournament.getSeason().getName())
                .build();
    }

    public TournamentDTO mapToDTO(Tournament tournament){
        return TournamentDTO.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .matches(tournament.getMatches()
                            .stream()
                            .map(matchMapperImpl::map)
                            .toList())
                .size(tournament.getSize())
                .active(tournament.getActive())
                .closed(tournament.getClosed())
                .build();
    }
}
