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
            List<AddAchievementDTO> max = dto.getMax();
            max.forEach(addAchievementDTO -> {
                Achievement maxAchievement = Achievement.builder()
                        .player(Player.builder()
                                .playerId(addAchievementDTO.getPlayerId())
                                .build())
                        .tournament(Tournament.builder()
                                .tournamentId(addAchievementDTO.getTournamentId())
                                .build())
                        .type(AchievementType.MAX)
                        .value(null)
                        .build();
                achievements.add(maxAchievement);
            });
        }

        if(dto.getOneSeventy() != null){
            List<AddAchievementDTO> oneSeventy = dto.getOneSeventy();
            oneSeventy.forEach(addAchievementDTO -> {
                Achievement oneSeventyAchievement = Achievement.builder()
                        .player(Player.builder()
                                .playerId(addAchievementDTO.getPlayerId())
                                .build())
                        .tournament(Tournament.builder()
                                .tournamentId(addAchievementDTO.getTournamentId())
                                .build())
                        .type(AchievementType.ONESEVENTY)
                        .value(addAchievementDTO.getValue())
                        .build();
                achievements.add(oneSeventyAchievement);
            });
        }

        if(dto.getHf() != null){
            List<AddAchievementDTO> hf = dto.getHf();
            hf.forEach(addAchievementDTO -> {
                Achievement hfAchievement = Achievement.builder()
                        .player(Player.builder()
                                .playerId(addAchievementDTO.getPlayerId())
                                .build())
                        .tournament(Tournament.builder()
                                .tournamentId(addAchievementDTO.getTournamentId())
                                .build())
                        .type(AchievementType.HF)
                        .value(addAchievementDTO.getValue())
                        .build();
                achievements.add(hfAchievement);
            });
        }

        if(dto.getQf() != null){
            List<AddAchievementDTO> qf = dto.getQf();
            qf.forEach(addAchievementDTO -> {
                Achievement qfAchievement = Achievement.builder()
                        .player(Player.builder()
                                .playerId(addAchievementDTO.getPlayerId())
                                .build())
                        .tournament(Tournament.builder()
                                .tournamentId(addAchievementDTO.getTournamentId())
                                .build())
                        .type(AchievementType.QF)
                        .value(addAchievementDTO.getValue())
                        .build();
                achievements.add(qfAchievement);
            });
        }

        if(achievements.size() > 0){
            achievementDAO.addAchievements(achievements);
        }
    }
}
