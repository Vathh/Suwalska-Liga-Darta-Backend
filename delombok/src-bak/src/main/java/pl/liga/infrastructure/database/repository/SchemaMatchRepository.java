package pl.liga.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.SchemaMatchDAO;
import pl.liga.domain.SchemaMatch;
import pl.liga.infrastructure.database.repository.jpa.SchemaMatchJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.SchemaMatchEntityMapper;

import java.util.List;

@Repository
@AllArgsConstructor
public class SchemaMatchRepository implements SchemaMatchDAO {

    private final SchemaMatchJpaRepository repository;

    private final SchemaMatchEntityMapper mapper;


    @Override
    public List<SchemaMatch> findSchemaMatches(Integer playersCount) {
        return repository.findSchemaMatches(playersCount)
                            .stream()
                            .map(mapper::mapFromEntity)
                            .toList();
    }
}
