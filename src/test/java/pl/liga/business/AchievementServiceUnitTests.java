package pl.liga.business;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.liga.api.dto.AddAchievementDTO;
import pl.liga.business.dao.AchievementDAO;
import pl.liga.domain.Achievement;
import pl.liga.domain.AchievementType;
import pl.liga.domain.Player;
import pl.liga.domain.Tournament;
import pl.liga.util.DomainFixtures;
import pl.liga.util.DtoFixtures;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AchievementServiceUnitTests {

    @Mock
    private AchievementDAO achievementDAO;

    @InjectMocks
    private AchievementService achievementService;

    @Test
    void thatPrepareMaxAchievementsWorksCorrectly(){
        //given
        List<AddAchievementDTO> max = List.of(DtoFixtures.someAddAchievementDTO1());

        //when
        List<Achievement> result = achievementService.prepareAchievements(max, AchievementType.MAX);

        //then
        assertThat(result).isEqualTo(List.of(Achievement.builder()
                        .player(Player.builder().playerId(1).build())
                        .tournament(Tournament.builder().tournamentId(1).build())
                        .type(AchievementType.MAX)
                        .value(null)
                .build()));
    }

    @Test
    void thatPrepareOneSeventyAchievementsWorksCorrectly(){
        //given
        List<AddAchievementDTO> oneSeventies = List.of(DtoFixtures.someAddAchievementDTO2());

        //when
        List<Achievement> result = achievementService.prepareAchievements(oneSeventies, AchievementType.ONESEVENTY);

        //then
        assertThat(result).isEqualTo(List.of(Achievement.builder()
                .player(Player.builder().playerId(2).build())
                .tournament(Tournament.builder().tournamentId(2).build())
                .type(AchievementType.ONESEVENTY)
                .value(171)
                .build()));
    }

    @Test
    void thatPrepareHfAchievementsWorksCorrectly(){
        //given
        List<AddAchievementDTO> hfs = List.of(DtoFixtures.someAddAchievementDTO3());

        //when
        List<Achievement> result = achievementService.prepareAchievements(hfs, AchievementType.HF);

        //then
        assertThat(result).isEqualTo(List.of(Achievement.builder()
                .player(Player.builder().playerId(3).build())
                .tournament(Tournament.builder().tournamentId(3).build())
                .type(AchievementType.HF)
                .value(151)
                .build()));
    }

    @Test
    void thatPrepareQfAchievementsWorksCorrectly(){
        //given
        List<AddAchievementDTO> qfs = List.of(DtoFixtures.someAddAchievementDTO4());

        //when
        List<Achievement> result = achievementService.prepareAchievements(qfs, AchievementType.QF);

        //then
        assertThat(result).isEqualTo(List.of(Achievement.builder()
                .player(Player.builder().playerId(4).build())
                .tournament(Tournament.builder().tournamentId(4).build())
                .type(AchievementType.QF)
                .value(19)
                .build()));
    }
}
