package pl.liga.infrastructure.database.repository;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.liga.business.dao.PlayerDAO;
import pl.liga.domain.Player;
import pl.liga.infrastructure.database.entity.PlayerEntity;
import pl.liga.infrastructure.database.repository.jpa.PlayerJpaRepository;
import pl.liga.infrastructure.database.repository.mapper.PlayerEntityMapperImpl;

import java.util.List;

@Repository
@AllArgsConstructor
public class PlayerRepository implements PlayerDAO {

    private EntityManager entityManager;
    private final PlayerJpaRepository playerJpaRepository;

    private final PlayerEntityMapperImpl playerEntityMapperImpl;

    @Override
    public List<Player> findAll() {
        return playerJpaRepository.findAll()
                .stream()
                .map(playerEntityMapperImpl::mapFromEntityWithoutPlayerAndTournament)
                .toList();
    }

    @Override
    public void savePlayer(Player player) {
        PlayerEntity entity = playerEntityMapperImpl.mapToEntityWithoutResultsAndAchievements(player);
        playerJpaRepository.saveAndFlush(entity);
    }

    @Override
    public List<Player> findPlayersByIdsWithoutResultsAndAchievements(List<Integer> playersIds) {

        return playerJpaRepository.findPlayersByIdsWithoutResultsAndAchievements(playersIds)
                .stream()
                .map(playerEntityMapperImpl::mapFromEntityWithoutPlayerAndTournament)
                .toList();
    }

    @Override
    public List<Player> findAllWithAchievementsAndResults() {
        return playerJpaRepository.findAllWithAchievementsAndResults()
                .stream()
                .map(playerEntityMapperImpl::mapFromEntityWithoutPlayerAndTournament)
                .toList();
    }
}
