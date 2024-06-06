package pl.liga.business.dao;

import pl.liga.domain.Match;
import pl.liga.domain.Tournament;

import java.util.List;
import java.util.Optional;

public interface MatchDAO {

    List<Match> findAll();
    Match findMatch(String markup, Integer tournamentId);
    List<Match> findMatchesByTournamentId(Integer tournamentId);
    void updateMatch(Integer matchId, Integer winnerId, Integer loserId);
    void setPlayerA(Integer matchId, Integer playerId);
    void setPlayerB(Integer matchId, Integer playerId);
    List<Match> findActiveMatches();
    void deleteMatchesByTournamentId(Integer tournamentId);
}
