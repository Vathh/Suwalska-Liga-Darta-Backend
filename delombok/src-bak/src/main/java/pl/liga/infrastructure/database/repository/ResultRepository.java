package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.ResultDAO;
import pl.liga.domain.Result;
import pl.liga.infrastructure.database.repository.jpa.ResultJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.ResultEntityMapper;

import java.util.List;

@Repository
@AllArgsConstructor
public class ResultRepository implements ResultDAO {

    private final ResultJpaRepository resultJpaRepository;

    private final ResultEntityMapper resultEntityMapper;

    @Override
    public List<Result> findAll() {
        return null;
    }

    @Override
    public void savePresences(List<Result> results) {

    }
}
