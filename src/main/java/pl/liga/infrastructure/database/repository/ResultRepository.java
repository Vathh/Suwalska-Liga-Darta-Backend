package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.ResultDAO;
import pl.liga.domain.Result;
import pl.liga.infrastructure.database.repository.jpa.ResultJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.ResultEntityMapperImpl;

@Repository
@AllArgsConstructor
public class ResultRepository implements ResultDAO {

    private final ResultJpaRepository resultJpaRepository;

    private final ResultEntityMapperImpl resultEntityMapperImpl;

    @Override
    public void addResult(Result result) {
        resultJpaRepository.saveAndFlush(resultEntityMapperImpl.mapToEntity(result));
    }
}
