package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.ResultEntity;

@Repository
public interface ResultJpaRepository extends JpaRepository<ResultEntity, Integer> {

}
