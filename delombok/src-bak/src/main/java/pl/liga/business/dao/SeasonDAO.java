package pl.liga.business.dao;

import pl.liga.domain.Season;

import java.util.List;

public interface SeasonDAO {

    List<Season> findAll();
    void addSeason(Season season);
}
