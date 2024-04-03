package pl.liga.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.liga.infrastructure.database.entity.TournamentEntity;

@Repository
public interface TournamentJpaRepository extends JpaRepository<TournamentEntity, Integer> {

}
