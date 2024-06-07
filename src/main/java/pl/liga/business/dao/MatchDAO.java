package pl.liga.business.dao;

import pl.liga.domain.Match;

import java.util.List;

public interface MatchDAO {
    List<Match> findActiveMatches();
    Match findMatch(String markup, Integer tournamentId);
    List<Match> findMatchesByTournamentId(Integer tournamentId);
    void updateMatch(Integer matchId, Integer winnerId, Integer loserId);
    void setPlayerA(Integer matchId, Integer playerId);
    void setPlayerB(Integer matchId, Integer playerId);
    void deleteMatchesByTournamentId(Integer tournamentId);
}
