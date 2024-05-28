package pl.liga.infrastructure.database.repository.mapper;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Component
public class TournamentEntityMapperImpl {

    private final AchievementEntityMapperImpl achievementEntityMapper;
    private final ResultEntityMapperImpl resultEntityMapper;
    private final MatchEntityMapperImpl matchEntityMapper;
    private final SeasonEntityMapperImpl seasonEntityMapper;

    public TournamentEntityMapperImpl(@Lazy AchievementEntityMapperImpl achievementEntityMapper,
                                      @Lazy ResultEntityMapperImpl resultEntityMapper,
                                      @Lazy MatchEntityMapperImpl matchEntityMapper,
                                      @Lazy SeasonEntityMapperImpl seasonEntityMapper){
        this.achievementEntityMapper = achievementEntityMapper;
        this.resultEntityMapper = resultEntityMapper;
        this.matchEntityMapper = matchEntityMapper;
        this.seasonEntityMapper = seasonEntityMapper;
    }

    public Tournament mapFromEntityWithoutMatchesAndSeason(TournamentEntity entity){
        return Tournament.builder()
                .tournamentId(entity.getTournamentId())
                .date(entity.getDate())
                .results(entity.getResults()
                        .stream()
                        .map(resultEntityMapper::mapFromEntityWithoutTournament)
                        .toList())
                .achievements(entity.getAchievements()
                        .stream()
                        .map(achievementEntityMapper::mapFromEntityWithoutTournament)
                        .toList())
                .size(entity.getSize())
                .active(entity.getActive())
                .closed(entity.getClosed())
                .build();
    }

    public TournamentEntity mapToEntityWithoutResultsAchievementsAndMatches(Tournament tournament){
        return TournamentEntity.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .size(tournament.getSize())
                .active(tournament.getActive())
                .closed(tournament.getClosed())
                .season(seasonEntityMapper.mapToEntity(tournament.getSeason()))
                .build();
    }

    public Tournament mapFromEntityIdOnly(TournamentEntity entity){
        return Tournament.builder()
                .tournamentId(entity.getTournamentId())
                .build();
    }

    public TournamentEntity mapToEntityIdOnly(Tournament tournament){
        return TournamentEntity.builder()
                .tournamentId(tournament.getTournamentId())
                .build();
    }

    public Tournament mapFromEntity(TournamentEntity entity){
        return Tournament.builder()
                .tournamentId(entity.getTournamentId())
                .date(entity.getDate())
                .results(entity.getResults()
                        .stream()
                        .map(resultEntityMapper::mapFromEntity)
                        .toList())
                .achievements(entity.getAchievements()
                        .stream()
                        .map(achievementEntityMapper::mapFromEntity)
                        .toList())
                .matches(entity.getMatches()
                        .stream()
                        .map(matchEntityMapper::mapFromEntity)
                        .toList())
                .size(entity.getSize())
                .active(entity.getActive())
                .closed(entity.getClosed())
                .season(seasonEntityMapper.mapFromEntity(entity.getSeason()))
                .build();
    }

    public TournamentEntity mapToEntity(Tournament tournament){
        return TournamentEntity.builder()
                .tournamentId(tournament.getTournamentId())
                .date(tournament.getDate())
                .results(tournament.getResults()
                        .stream()
                        .map(resultEntityMapper::mapToEntity)
                        .toList())
                .achievements(tournament.getAchievements()
                        .stream()
                        .map(achievementEntityMapper::mapToEntity)
                        .toList())
                .matches(tournament.getMatches()
                        .stream()
                        .map(matchEntityMapper::mapToEntity)
                        .toList())
                .size(tournament.getSize())
                .active(tournament.getActive())
                .closed(tournament.getClosed())
                .season(seasonEntityMapper.mapToEntity(tournament.getSeason()))
                .build();
    }
}
