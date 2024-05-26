package pl.liga.business.dao;

import pl.liga.domain.Season;

import java.util.Date;
import java.util.List;

public interface SeasonDAO {

    List<Season> findAll();
    void addSeason(Season season);

    Season findByName(String name);

    Season findBySeasonId(Integer seasonId);
    void deleteSeason(Integer seasonId);
    List<Season> findAllWithTournaments();
}
