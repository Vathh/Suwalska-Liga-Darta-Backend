package pl.liga.business.dao;

import pl.liga.domain.Match;
import pl.liga.domain.Tournament;

import java.util.List;

public interface MatchDAO {

    List<Match> findAll();

    void saveMatches(List<Match> matches);

    void saveMatch(Match match);

    Match findMatch(String markup, Tournament tournament);
}
