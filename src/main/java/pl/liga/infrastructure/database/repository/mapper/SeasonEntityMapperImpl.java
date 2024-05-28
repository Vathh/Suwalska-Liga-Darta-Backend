package pl.liga.infrastructure.database.repository.mapper;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Season;
import pl.liga.infrastructure.database.entity.SeasonEntity;

@Component
public class SeasonEntityMapperImpl {

    private final TournamentEntityMapperImpl tournamentEntityMapper;

    public SeasonEntityMapperImpl(@Lazy TournamentEntityMapperImpl tournamentEntityMapper){
        this.tournamentEntityMapper = tournamentEntityMapper;
    }

    public Season mapFromEntityWithoutMatchesAndSeason(SeasonEntity entity){
        return Season.builder()
                .seasonId(entity.getSeasonId())
                .name(entity.getName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .toDelete(entity.getToDelete())
                .tournaments(entity.getTournaments()
                        .stream()
                        .map(tournamentEntityMapper::mapFromEntityWithoutMatchesAndSeason)
                        .toList())
                .rankCount(entity.getRankCount())
                .build();
    }

    public SeasonEntity mapToEntityWithoutResultsAchievementsAndMatches(Season season){
        return SeasonEntity.builder()
                .seasonId(season.getSeasonId())
                .name(season.getName())
                .startDate(season.getStartDate())
                .endDate(season.getEndDate())
                .toDelete(season.getToDelete())
                .tournaments(season.getTournaments()
                        .stream()
                        .map(tournamentEntityMapper::mapToEntityWithoutResultsAchievementsAndMatches)
                        .toList())
                .rankCount(season.getRankCount())
                .build();
    }


    public Season mapFromEntity(SeasonEntity entity){
        return Season.builder()
                .seasonId(entity.getSeasonId())
                .name(entity.getName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .toDelete(entity.getToDelete())
                .tournaments(entity.getTournaments()
                        .stream()
                        .map(tournamentEntityMapper::mapFromEntity)
                        .toList())
                .rankCount(entity.getRankCount())
                .build();
    }

    public SeasonEntity mapToEntity(Season season){
        return SeasonEntity.builder()
                .seasonId(season.getSeasonId())
                .name(season.getName())
                .startDate(season.getStartDate())
                .endDate(season.getEndDate())
                .toDelete(season.getToDelete())
                .tournaments(season.getTournaments()
                        .stream()
                        .map(tournamentEntityMapper::mapToEntity)
                        .toList())
                .rankCount(season.getRankCount())
                .build();
    }
}
