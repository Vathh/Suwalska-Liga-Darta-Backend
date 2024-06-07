package pl.liga.business.dao;

import pl.liga.domain.Tournament;

import java.util.List;

public interface TournamentDAO {
    List<Tournament> findAllWithoutResultsAchievementsMatches();
    Tournament findByIdWithoutMatches(Integer tournamentId);
    Tournament findActiveTournament();
    void saveTournament(Tournament tournament);
    void endTournament(Integer tournamentId);
    void cancelActiveTournament(Integer tournamentId);
    void deleteTournament(Integer tournamentId);
}
