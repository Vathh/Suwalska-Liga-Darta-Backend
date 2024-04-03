package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.liga.infrastructure.database.entity.SchemaMatchEntity;

import java.util.Set;

public interface SchemaMatchJpaRepository extends JpaRepository<SchemaMatchEntity, Integer>{

    @Query("""
            SELECT sm FROM SchemaMatchEntity sm
            WHERE sm.schemaSize = :size
            """)
    Set<SchemaMatchEntity> findSchemaMatches(final @Param("size") Integer size);

}
