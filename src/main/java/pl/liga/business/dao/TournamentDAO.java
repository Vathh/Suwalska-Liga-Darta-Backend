package pl.liga.business.dao;

import pl.liga.domain.Tournament;

import java.util.List;

public interface TournamentDAO {

    List<Tournament> findAllWithoutResultsAchievementsMatches();

    void saveTournament(Tournament tournament);

    Tournament findByIdWithoutMatches(Integer tournamentId);

    Tournament findActiveTournament();

    void endTournament(Integer tournamentId);

    void deleteTournament(Integer tournamentId);

    void cancelActiveTournament(Integer tournamentId);
}
