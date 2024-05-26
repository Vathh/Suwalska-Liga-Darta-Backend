package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.liga.business.dao.SeasonDAO;
import pl.liga.domain.Season;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SeasonService {

    private final SeasonDAO seasonDAO;

    @Transactional
    public List<Season> findAll(){
        return seasonDAO.findAll();
    }

    @Transactional
    public void addSeason(Season season){
        seasonDAO.addSeason(season);
    }

    @Transactional
    public Season findSeasonByName(String name){
        return seasonDAO.findByName(name);
    }

    @Transactional
    public Season findBySeasonId(Integer seasonId){
        return seasonDAO.findBySeasonId(seasonId);
    }

    @Transactional
    public void deleteSeason(Integer seasonId){
        seasonDAO.deleteSeason(seasonId);
    }
}
