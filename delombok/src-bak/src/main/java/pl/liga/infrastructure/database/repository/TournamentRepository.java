package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.TournamentDAO;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.repository.jpa.TournamentJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.TournamentEntityMapper;

import java.util.List;

@Repository
@AllArgsConstructor
public class TournamentRepository implements TournamentDAO {

    private final TournamentJpaRepository tournamentJpaRepository;

    private final TournamentEntityMapper tournamentEntityMapper;

    @Override
    public List<Tournament> findAll() {
        return null;
    }

    @Override
    public void saveTournament(Tournament tournament) {
        tournamentJpaRepository.saveAndFlush(tournamentEntityMapper.mapToEntity(tournament));
    }

    @Override
    public Tournament getRandomTournament() {
        return tournamentEntityMapper.mapFromEntity(tournamentJpaRepository.findAll().stream().findFirst().get());
    }
}
