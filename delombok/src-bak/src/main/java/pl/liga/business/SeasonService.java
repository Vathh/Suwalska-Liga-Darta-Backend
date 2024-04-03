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
    public List<Season> findAllSeasons(){
        return seasonDAO.findAll();
    }

    @Transactional
    public void addSeason(Season season){
        seasonDAO.addSeason(season);
    }
}
