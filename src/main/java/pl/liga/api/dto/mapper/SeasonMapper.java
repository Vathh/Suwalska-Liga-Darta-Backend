package pl.liga.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.liga.api.dto.SeasonDTO;
import pl.liga.domain.Season;
import pl.liga.domain.Tournament;

@Mapper(componentModel = "spring")
public interface SeasonMapper {

    default SeasonDTO map(final Season season){
        return SeasonDTO.builder()
                .seasonId(season.getSeasonId())
                .name(season.getName())
                .startDate(season.getStartDate())
                .endDate(season.getEndDate())
                .toDelete(season.getToDelete())
                .tournamentFridays(
    season.getTournaments()
                    .stream()
                    .map(Tournament::getDate)
                    .toList())
                .rankCount(season.getRankCount())
                .build();
    }

    default Season map(final SeasonDTO seasonDTO){
        return Season.builder()
                .name(seasonDTO.getName())
                .startDate(seasonDTO.getStartDate())
                .endDate(seasonDTO.getEndDate())
                .toDelete(seasonDTO.getToDelete())
                .tournaments(seasonDTO.getTournamentFridays()
                        .stream()
                        .map(friday -> Tournament.builder()
                                .date(friday)
                                .closed(false)
                                .active(false)
                                .build()).toList())
                .rankCount(seasonDTO.getRankCount())
                .build();
    }
}
