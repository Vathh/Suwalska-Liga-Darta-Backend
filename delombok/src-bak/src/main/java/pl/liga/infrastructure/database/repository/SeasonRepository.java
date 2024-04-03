package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.SeasonDAO;
import pl.liga.domain.Season;
import pl.liga.infrastructure.database.repository.jpa.SeasonJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.SeasonEntityMapper;

import java.util.List;

@Repository
@AllArgsConstructor
public class SeasonRepository implements SeasonDAO {

    private final SeasonJpaRepository seasonJpaRepository;
    private final SeasonEntityMapper seasonEntityMapper;

    @Override
    public List<Season> findAll() {
        return seasonJpaRepository.findAll()
                .stream()
                .map(seasonEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public void addSeason(Season season) {
        seasonJpaRepository.saveAndFlush(
                seasonEntityMapper.mapToEntity(season)
        );
    }
}
