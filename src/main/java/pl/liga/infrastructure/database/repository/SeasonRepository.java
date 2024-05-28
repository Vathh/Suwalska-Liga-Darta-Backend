package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.SeasonDAO;
import pl.liga.domain.Season;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.SeasonEntity;
import pl.liga.infrastructure.database.entity.TournamentEntity;
import pl.liga.infrastructure.database.repository.jpa.SeasonJpaRepository;
import pl.liga.infrastructure.database.repository.jpa.TournamentJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.SeasonEntityMapperImpl;
import pl.liga.infrastructure.database.repository.mapper.TournamentEntityMapperImpl;

import java.util.List;

@Repository
@AllArgsConstructor
public class SeasonRepository implements SeasonDAO {

    private final SeasonJpaRepository seasonJpaRepository;
    private final TournamentJpaRepository tournamentJpaRepository;
    private final TournamentEntityMapperImpl tournamentEntityMapperImpl;
    private final SeasonEntityMapperImpl seasonEntityMapperImpl;

    @Override
    public List<Season> findAll() {
        return seasonJpaRepository.findAll()
                .stream()
                .map(seasonEntityMapperImpl::mapFromEntityWithoutMatchesAndSeason)
                .filter(season -> season.getToDelete().equals(false))
                .toList();
    }

    @Override
    public void addSeason(Season season) {
        seasonJpaRepository.saveAndFlush(
                seasonEntityMapperImpl.mapToEntityWithoutResultsAchievementsAndMatches(season)
        );

        SeasonEntity seasonEntity = seasonJpaRepository.findByName(season.getName());
        List<Tournament> tournaments = season.getTournaments();
        List<TournamentEntity> tournamentEntities = tournaments.stream()
                                                        .map(tournamentEntityMapperImpl::mapToEntityWithoutResultsAchievementsAndMatches)
                                                        .toList();
        tournamentEntities.forEach(tournamentEntity -> tournamentEntity.setSeason(seasonEntity));
        tournamentJpaRepository.saveAllAndFlush(tournamentEntities);
    }

    @Override
    public Season findByName(String name) {
        return seasonEntityMapperImpl.mapFromEntityWithoutMatchesAndSeason(seasonJpaRepository.findByName(name));
    }

    @Override
    public Season findBySeasonId(Integer seasonId) {
        return seasonEntityMapperImpl.mapFromEntityWithoutMatchesAndSeason(seasonJpaRepository.findBySeasonId(seasonId));
    }

    @Override
    public void deleteSeason(Integer seasonId) {
        seasonJpaRepository.deleteBySeasonId(seasonId);
    }

    @Override
    public List<Season> findAllWithTournaments() {
        return seasonJpaRepository.findAllWithTournaments()
                .stream()
                .map(seasonEntityMapperImpl::mapFromEntityWithoutMatchesAndSeason)
                .filter(season -> season.getToDelete().equals(false))
                .toList();
    }
}
