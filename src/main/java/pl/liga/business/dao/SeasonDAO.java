package pl.liga.business.dao;

import pl.liga.domain.Season;

import java.util.List;

public interface SeasonDAO {

    List<Season> findAll();
    Season findBySeasonId(Integer seasonId);
    void addSeason(Season season);
    void deleteSeason(Integer seasonId);
}
