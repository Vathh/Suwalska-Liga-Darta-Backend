package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.MatchDAO;
import pl.liga.domain.Match;
import pl.liga.infrastructure.database.entity.MatchEntity;
import pl.liga.infrastructure.database.repository.jpa.MatchJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.MatchEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MatchRepository implements MatchDAO {

    private final MatchJpaRepository matchJpaRepository;

    private final MatchEntityMapper matchEntityMapper;

    @Override
    public List<Match> findAll() {
        return matchJpaRepository.findAll()
                .stream()
                .map(matchEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public void saveMatches(List<Match> matches) {
        matchJpaRepository.saveAllAndFlush(
                matches.stream()
                        .map(matchEntityMapper::mapToEntity)
                        .toList());
    }

    @Override
    public void saveMatch(Match match) {
        matchJpaRepository.saveAndFlush(matchEntityMapper.mapToEntity(match));
    }

    @Override
    public Match findMatch(String markup, Integer tournamentId) {
        Optional<MatchEntity> matchEntity = matchJpaRepository.findMatch(markup, tournamentId);
        return matchEntity.map(matchEntityMapper::mapFromEntity).orElse(null);
    }

    @Override
    public Match findById(Integer matchId) {
        Optional<MatchEntity> matchEntity = matchJpaRepository.findById(matchId);
        return matchEntity.map(matchEntityMapper::mapFromEntity).orElse(null);
    }

    @Override
    public List<Match> findMatchesByTournamentId(Integer tournamentId) {
        return matchJpaRepository.findMatchesByTournamentId(tournamentId)
                                .stream()
                                .map(matchEntityMapper::mapFromEntity)
                                .toList();
    }

    @Override
    public void updateMatch(Integer matchId, Integer winnerId, Integer loserId) {
        matchJpaRepository.updateMatch(matchId, winnerId, loserId);
    }

    @Override
    public void setPlayerA(Integer matchId, Integer playerId) {
        matchJpaRepository.setPlayerA(matchId, playerId);
    }

    @Override
    public void setPlayerB(Integer matchId, Integer playerId) {
       matchJpaRepository.setPlayerB(matchId, playerId);
    }

    @Override
    public List<Match> findActiveMatches() {
        return matchJpaRepository.findActiveMatches()
                                .stream()
                                .map(matchEntityMapper::mapFromEntity)
                                .toList();
    }

    @Override
    public void deleteMatchesByTournamentId(Integer tournamentId) {
        matchJpaRepository.deleteMatchesByTournamentId(tournamentId);
    }
}
