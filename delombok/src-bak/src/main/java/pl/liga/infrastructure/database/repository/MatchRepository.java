package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.MatchDAO;
import pl.liga.domain.Match;
import pl.liga.domain.Tournament;
import pl.liga.infrastructure.database.repository.jpa.MatchJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.MatchEntityMapper;
import pl.liga.infrastructure.database.repository.mapper.TournamentEntityMapper;

import java.util.List;

@Repository
@AllArgsConstructor
public class MatchRepository implements MatchDAO {

    private final MatchJpaRepository matchJpaRepository;

    private final MatchEntityMapper matchEntityMapper;
    private final TournamentEntityMapper tournamentEntityMapper;

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
    public Match findMatch(String markup, Tournament tournament) {
        return matchEntityMapper.mapFromEntity(
                matchJpaRepository.findMatch(markup,
                                    tournamentEntityMapper.mapToEntity(tournament)).get());
    }
}
