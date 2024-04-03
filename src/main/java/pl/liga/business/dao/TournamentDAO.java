package pl.liga.business.dao;

import pl.liga.domain.Tournament;

import java.util.List;

public interface TournamentDAO {

    List<Tournament> findAll();

    void saveTournament(Tournament tournament);

    void saveTournaments(List<Tournament> tournaments);

    Tournament findById(Integer tournamentId);

    Tournament getRandomTournament();

    Tournament findByIdWithoutResultsAchievementsMatchesSeason(Integer tournamentId);

    Tournament findActiveTournament();

    void endTournament(Integer tournamentId);

    Tournament findTournamentWithResults(Integer tournamentId);

    void deleteTournament(Integer tournamentId);
}
