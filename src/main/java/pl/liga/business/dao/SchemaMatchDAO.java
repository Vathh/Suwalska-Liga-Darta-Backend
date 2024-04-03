package pl.liga.business.dao;

import pl.liga.domain.SchemaMatch;

import java.util.List;

public interface SchemaMatchDAO {

    List<SchemaMatch> findSchemaMatches(Integer size);
}
