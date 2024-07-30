package pl.liga.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.liga.api.dto.PlayerDTO;
import pl.liga.api.dto.PlayerNameDTO;
import pl.liga.domain.Achievement;
import pl.liga.domain.AchievementType;
import pl.liga.domain.Player;

import java.util.Comparator;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    default PlayerDTO map(final Player player){

        PlayerDTO dto = PlayerDTO.builder()
                .playerId(player.getPlayerId())
                .name(player.getName())
                .build();

        if(player.getAchievements() != null){
            Integer max = Math.toIntExact(player.getAchievements()
                    .stream()
                    .filter(x -> x.getType().equals(AchievementType.MAX))
                    .count());

            Integer oneSeventy = Math.toIntExact(player.getAchievements()
                    .stream()
                    .filter(x -> x.getType().equals(AchievementType.ONESEVENTY))
                    .count());

            Optional<Achievement> hf = player.getAchievements()
                    .stream()
                    .filter(x -> x.getType().equals(AchievementType.HF))
                    .max(Comparator.comparingInt(Achievement::getValue));

            Optional<Achievement> qf = player.getAchievements()
                    .stream()
                    .filter(x -> x.getType().equals(AchievementType.QF))
                    .min(Comparator.comparingInt(Achievement::getValue));


            hf.ifPresent(achievement -> dto.setHf(achievement.getValue()));
            qf.ifPresent(achievement -> dto.setQf(achievement.getValue()));
            dto.setMax(max);
            dto.setOneSeventy(oneSeventy);
        }

        return dto;
    };

    default PlayerNameDTO mapWithoutAchievementsResults(final Player player){
        return PlayerNameDTO.builder()
                .playerId(player.getPlayerId())
                .name(player.getName())
                .build();
    }

    @Mapping(target = "achievements", ignore = true)
    @Mapping(target = "results", ignore = true)
    Player map(PlayerDTO playerDTO);
}
