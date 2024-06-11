package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.liga.api.dto.AddAchievementDTO;
import pl.liga.api.dto.MatchAchievementsDTO;
import pl.liga.business.dao.AchievementDAO;
import pl.liga.domain.Achievement;
import pl.liga.domain.AchievementType;
import pl.liga.domain.Player;
import pl.liga.domain.Tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class AchievementService {
    private final AchievementDAO achievementDAO;

    @Transactional
    public void addAchievements(MatchAchievementsDTO dto){
        if(dto == null){
            return;
        }
        List<Achievement> achievements = new ArrayList<>();

        if(dto.getMax() != null){
            List<Achievement> max = prepareAchievements(dto.getMax(), AchievementType.MAX);
            achievements.addAll(max);
        }

        if(dto.getOneSeventy() != null){
            List<Achievement> oneSeventies = prepareAchievements(dto.getOneSeventy(), AchievementType.ONESEVENTY);
            achievements.addAll(oneSeventies);
        }

        if(dto.getHf() != null){
            List<Achievement> hfs = prepareAchievements(dto.getHf(), AchievementType.HF);
            achievements.addAll(hfs);
        }

        if(dto.getQf() != null){
            List<Achievement> qfs = prepareAchievements(dto.getQf(), AchievementType.QF);
            achievements.addAll(qfs);
        }

        if(achievements.size() > 0){
            achievementDAO.addAchievements(achievements);
        }
    }

    private List<Achievement> prepareAchievements(List<AddAchievementDTO> dtos, String type){
        return dtos.stream().map(addAchievementDTO ->
                                    Achievement.builder()
                                                .player(Player.builder()
                                                        .playerId(addAchievementDTO.getPlayerId())
                                                        .build())
                                                .tournament(Tournament.builder()
                                                        .tournamentId(addAchievementDTO.getTournamentId())
                                                        .build())
                                                .type(type)
                                                .value(Objects.equals(type, AchievementType.MAX) ? null : addAchievementDTO.getValue())
                                                .build())
                                            .toList();
    }
}
