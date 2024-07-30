package pl.liga.util;

import pl.liga.api.dto.*;
import pl.liga.domain.AchievementType;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
public class DtoFixtures {

    public static AchievementDTO someAchievementDTO1(){
        return AchievementDTO.builder()
                .playerName("Andrzej")
                .type(AchievementType.MAX)
                .value(null)
                .build();
    }

    public static AchievementDTO someAchievementDTO2(){
        return AchievementDTO.builder()
                .playerName("Marian")
                .type(AchievementType.ONESEVENTY)
                .value(171)
                .build();
    }

    public static AddAchievementDTO someAddAchievementDTO1(){
        return AddAchievementDTO.builder()
                .playerId(1)
                .tournamentId(1)
                .type(AchievementType.MAX)
                .value(null)
                .build();
    }

    public static AddAchievementDTO someAddAchievementDTO2(){
        return AddAchievementDTO.builder()
                .playerId(2)
                .tournamentId(2)
                .type(AchievementType.ONESEVENTY)
                .value(171)
                .build();
    }

    public static AddAchievementDTO someAddAchievementDTO3(){
        return AddAchievementDTO.builder()
                .playerId(3)
                .tournamentId(3)
                .type(AchievementType.HF)
                .value(151)
                .build();
    }

    public static AddAchievementDTO someAddAchievementDTO4(){
        return AddAchievementDTO.builder()
                .playerId(4)
                .tournamentId(4)
                .type(AchievementType.QF)
                .value(19)
                .build();
    }

    public static MatchAchievementsDTO someMatchAchievementsDTO1(){
        return MatchAchievementsDTO.builder()
                .max(List.of(someAddAchievementDTO1()))
                .oneSeventy(List.of(someAddAchievementDTO2()))
                .hf(List.of(someAddAchievementDTO3()))
                .qf(List.of(someAddAchievementDTO4()))
                .build();
    }

    public static MatchDTO someMatchDTO1(){
        return MatchDTO.builder()
                .playerA(somePlayerNameDTO1())
                .playerB(somePlayerNameDTO2())
                .winner(somePlayerNameDTO1())
                .loser(somePlayerNameDTO2())
                .tournamentId(1)
                .markup("PA1")
                .winnerDestinationMarkup("PB1")
                .loserDestinationMarkup("LA1")
                .points(1)
                .active(false)
                .build();
    }

    public static MatchResultDTO someMatchResultDTO1(){
        return MatchResultDTO.builder()
                .matchAchievementsDTO(someMatchAchievementsDTO1())
                .updateMatchDTO(someUpdateMatchDTO1())
                .build();
    }

    public static PlayerDTO somePlayerDTO1(){
        return PlayerDTO.builder()
                .name("Andrzej")
                .hf(151)
                .qf(19)
                .max(3)
                .oneSeventy(2)
                .build();
    }

    public static PlayerNameDTO somePlayerNameDTO1(){
        return PlayerNameDTO.builder()
                .name("Andrzej")
                .build();
    }

    public static PlayerNameDTO somePlayerNameDTO2(){
        return PlayerNameDTO.builder()
                .name("Marian")
                .build();
    }

    public static PlayerSummaryDTO somePlayerSummaryDTO1(){
        return PlayerSummaryDTO.builder()
                .name("Andrzej")
                .rank(1)
                .total(10)
                .frequency(15)
                .max(3)
                .oneSeventy(2)
                .hf(151)
                .qf(19)
                .build();
    }

    public static ResultDTO someResultDTO1(){
        return ResultDTO.builder()
                .playerName("Andrzej")
                .pointsEarned(1)
                .build();
    }

    public static SeasonDTO someSeasonDTO1(){
        return SeasonDTO.builder()
                .name("TEST1")
                .startDate(new Date(2024, Calendar.JANUARY, 1))
                .endDate(new Date(2024, Calendar.FEBRUARY,1))
                .toDelete(false)
                .tournamentFridays(List.of(
                        new Date(2024, Calendar.JANUARY, 1),
                        new Date(2024, Calendar.FEBRUARY, 1)))
                .rankCount(2)
                .build();
    }

    public static SeasonResultsDTO someSeasonResultsDTO1(){
        return SeasonResultsDTO.builder()
                .name("TEST1")
                .tournaments(List.of(someTournamentWithoutAchievementsMatchesDTO1()))
                .playerSummaries(List.of(somePlayerSummaryDTO1()))
                .build();
    }

    public static StartTournamentDTO someStartTournamentDTO1(){
        return StartTournamentDTO.builder()
                .tournamentId(1)
                .playersIds(new Integer[]{1, 2, 3})
                .build();
    }

    public static TournamentDTO someTournamentDTO1(){
        return TournamentDTO.builder()
                .date(new Date(2024, Calendar.JANUARY, 1))
                .matches(List.of(someMatchDTO1()))
                .size(48)
                .active(false)
                .closed(false)
                .build();
    }

    public static TournamentWithoutAchievementsMatchesDTO someTournamentWithoutAchievementsMatchesDTO1(){
        return TournamentWithoutAchievementsMatchesDTO.builder()
                .date(new Date(2024, Calendar.JANUARY, 1))
                .results(List.of(someResultDTO1()))
                .size(48)
                .active(false)
                .closed(false)
                .build();
    }

    public static TournamentWithoutAchievementsResultsMatchesDTO someTournamentWithoutAchievementsResultsMatchesDTO1(){
        return TournamentWithoutAchievementsResultsMatchesDTO.builder()
                .date(new Date(2024, Calendar.JANUARY, 1))
                .size(48)
                .active(false)
                .closed(false)
                .seasonName("TEST1")
                .build();
    }

    public static TournamentWithoutMatchesDTO someTournamentWithoutMatchesDTO1(){
        return TournamentWithoutMatchesDTO.builder()
                .date(new Date(2024, Calendar.JANUARY, 1))
                .results(List.of(someResultDTO1()))
                .achievements(List.of(someAchievementDTO1(), someAchievementDTO2()))
                .size(48)
                .active(false)
                .closed(false)
                .build();
    }

    public static UpdateMatchDTO someUpdateMatchDTO1(){
        return UpdateMatchDTO.builder()
                .tournamentId(1)
                .matchId(1)
                .winnerId(1)
                .loserId(2)
                .markup("PA1")
                .winnerDestinationMarkup("PB1")
                .loserDestinationMarkup("LA1")
                .points(1)
                .build();
    }
}
