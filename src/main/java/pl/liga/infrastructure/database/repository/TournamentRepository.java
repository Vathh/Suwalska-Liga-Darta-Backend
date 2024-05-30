package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.TournamentDAO;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.entity.TournamentEntity;
import pl.liga.infrastructure.database.repository.jpa.TournamentJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.TournamentEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TournamentRepository implements TournamentDAO {

    private final TournamentJpaRepository tournamentJpaRepository;

    private final TournamentEntityMapper tournamentEntityMapper;

    @Override
    public List<Tournament> findAll() {
        return tournamentJpaRepository.findAll().stream()
                .map(tournamentEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public void saveTournament(Tournament tournament) {

        TournamentEntity tournamentEntity = tournamentEntityMapper.mapToEntity(tournament);

        tournamentJpaRepository.save(tournamentEntity);
    }

    @Override
    public void saveTournaments(List<Tournament> tournaments) {
        List<TournamentEntity> entities = tournaments.stream()
                                                            .map(tournamentEntityMapper::mapToEntity)
                                                            .toList();
        tournamentJpaRepository.saveAllAndFlush(entities);
    }

    @Override
    public Tournament findById(Integer tournamentId) {
        Optional<TournamentEntity> tournamentEntity = tournamentJpaRepository.findById(tournamentId);
        return tournamentEntity.map(tournamentEntityMapper::mapFromEntity).orElse(null);
    }

    @Override
    public Tournament getRandomTournament() {
        return tournamentEntityMapper.mapFromEntity(tournamentJpaRepository.findAll().stream().findFirst().get());
    }

    @Override
    public Tournament findByIdWithoutResultsAchievementsMatchesSeason(Integer tournamentId) {
        Optional<TournamentEntity> tournament = tournamentJpaRepository.findByIdWithoutResultsAchievementsMatchesSeason(tournamentId);
        return tournament.map(tournamentEntityMapper::mapFromEntity).orElse(null);
    }

    @Override
    public Tournament findActiveTournament() {
        Optional<TournamentEntity> tournament = tournamentJpaRepository.findActiveTournament();
        return tournament.map(tournamentEntityMapper::mapFromEntity).orElse(null);
    }

    @Override
    public void endTournament(Integer tournamentId) {
        tournamentJpaRepository.endTournament(tournamentId);
    }

    @Override
    public Tournament findTournamentWithResults(Integer tournamentId) {
        Optional<TournamentEntity> tournament = tournamentJpaRepository.findById(tournamentId);
        return tournament.map(tournamentEntityMapper::mapFromEntity).orElse(null);
    }

    @Override
    public void deleteTournament(Integer tournamentId) {
        tournamentJpaRepository.deleteById(tournamentId);
    }

    @Override
    public void cancelActiveTournament(Integer tournamentId) {
        tournamentJpaRepository.cancelActiveTournament(tournamentId);
    }
}
