package pl.liga.business.dao;

import pl.liga.domain.Tournament;

import java.util.List;

public interface TournamentDAO {

    List<Tournament> findAllWithoutResultsAchievementsMatches();

    void saveTournament(Tournament tournament);

    void saveTournaments(List<Tournament> tournaments);

    Tournament findByIdWithoutMatches(Integer tournamentId);

    Tournament getRandomTournament();

    Tournament findByIdWithoutResultsAchievementsMatchesSeason(Integer tournamentId);

    Tournament findActiveTournament();

    void endTournament(Integer tournamentId);

    Tournament findTournamentWithResults(Integer tournamentId);

    void deleteTournament(Integer tournamentId);

    void cancelActiveTournament(Integer tournamentId);
}
