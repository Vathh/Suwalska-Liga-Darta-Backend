package pl.liga.business.dao;

import pl.liga.domain.Tournament;

import java.util.List;

public interface TournamentDAO {

    List<Tournament> findAll();

    void saveTournament(Tournament tournament);

    Tournament getRandomTournament();
}
