package pl.liga.util;

import pl.liga.domain.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
public class DomainFixtures {

    public static Achievement someAchievement1(){
        return Achievement.builder()
                .player(Player.builder()
                        .name("Andrzej")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.JANUARY, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.JANUARY, 1))
                                .endDate(new Date(2024, Calendar.FEBRUARY,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .type(AchievementType.MAX)
                .value(null)
                .build();
    }

    public static Achievement someAchievement2(){
        return Achievement.builder()
                .player(Player.builder()
                        .name("Marian")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.FEBRUARY, 12))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.JANUARY, 1))
                                .endDate(new Date(2024, Calendar.FEBRUARY,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .type(AchievementType.ONESEVENTY)
                .value(171)
                .build();
    }

    public static Achievement someAchievement3(){
        return Achievement.builder()
                .player(Player.builder()
                        .name("Maciej")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.MARCH, 13))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.JANUARY, 1))
                                .endDate(new Date(2024, Calendar.FEBRUARY,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .type(AchievementType.HF)
                .value(151)
                .build();
    }

    public static Achievement someAchievement4(){
        return Achievement.builder()
                .player(Player.builder()
                        .name("Tomek")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.APRIL, 14))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.JANUARY, 1))
                                .endDate(new Date(2024, Calendar.FEBRUARY,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .type(AchievementType.QF)
                .value(19)
                .build();
    }

    public static Match someMatch1(){
        return Match.builder()
                .playerA(Player.builder()
                        .name("Andrzej")
                        .build())
                .playerB(Player.builder()
                        .name("Marian")
                        .build())
                .winner(Player.builder()
                        .name("Andrzej")
                        .build())
                .loser(Player.builder()
                        .name("Marian")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.JANUARY, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.JANUARY, 1))
                                .endDate(new Date(2024, Calendar.FEBRUARY,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .markup("PA1")
                .winnerDestinationMarkup("PB1")
                .loserDestinationMarkup("LA1")
                .points(null)
                .active(true)
                .build();
    }

    public static Match someMatch2(){
        return Match.builder()
                .playerA(Player.builder()
                        .name("Marian")
                        .build())
                .playerB(Player.builder()
                        .name("Maciej")
                        .build())
                .winner(Player.builder()
                        .name("Marian")
                        .build())
                .loser(Player.builder()
                        .name("Maciej")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.FEBRUARY, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.FEBRUARY, 1))
                                .endDate(new Date(2024, Calendar.MARCH,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .markup("PA2")
                .winnerDestinationMarkup("PB2")
                .loserDestinationMarkup("LA2")
                .points(null)
                .active(true)
                .build();
    }

    public static Match someMatch3(){
        return Match.builder()
                .playerA(Player.builder()
                        .name("Maciej")
                        .build())
                .playerB(Player.builder()
                        .name("Tomek")
                        .build())
                .winner(Player.builder()
                        .name("Maciej")
                        .build())
                .loser(Player.builder()
                        .name("Tomek")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.MARCH, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.MARCH, 1))
                                .endDate(new Date(2024, Calendar.APRIL,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .markup("PA3")
                .winnerDestinationMarkup("PB3")
                .loserDestinationMarkup("LA3")
                .points(null)
                .active(true)
                .build();
    }

    public static Match someMatch4(){
        return Match.builder()
                .playerA(Player.builder()
                        .name("Tomek")
                        .build())
                .playerB(Player.builder()
                        .name("Andrzej")
                        .build())
                .winner(Player.builder()
                        .name("Tomek")
                        .build())
                .loser(Player.builder()
                        .name("Andrzej")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.APRIL, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.APRIL, 1))
                                .endDate(new Date(2024, Calendar.MAY,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .markup("PA4")
                .winnerDestinationMarkup("PB4")
                .loserDestinationMarkup("LA4")
                .points(null)
                .active(true)
                .build();
    }

    public static Player somePlayer1(){
        return Player.builder()
                .name("Andrzej")
                .achievements(List.of(someAchievement1()))
                .results(List.of(someResult1()))
                .build();
    }

    public static Player somePlayer2(){
        return Player.builder()
                .name("Marian")
                .achievements(List.of(someAchievement2()))
                .results(List.of(someResult2()))
                .build();
    }

    public static Player somePlayer3(){
        return Player.builder()
                .name("Maciej")
                .achievements(List.of(someAchievement3()))
                .results(List.of(someResult3()))
                .build();
    }

    public static Player somePlayer4(){
        return Player.builder()
                .name("Tomek")
                .achievements(List.of(someAchievement4()))
                .results(List.of(someResult4()))
                .build();
    }

    public static Result someResult1(){
        return Result.builder()
                .player(Player.builder()
                        .name("Andrzej")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.JANUARY, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.JANUARY, 1))
                                .endDate(new Date(2024, Calendar.FEBRUARY,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .pointsEarned(1)
                .build();
    }

    public static Result someResult2(){
        return Result.builder()
                .player(Player.builder()
                        .name("Marian")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.FEBRUARY, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.FEBRUARY, 1))
                                .endDate(new Date(2024, Calendar.MARCH,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .pointsEarned(3)
                .build();
    }

    public static Result someResult3(){
        return Result.builder()
                .player(Player.builder()
                        .name("Maciej")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.MARCH, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.MARCH, 1))
                                .endDate(new Date(2024, Calendar.APRIL,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .pointsEarned(5)
                .build();
    }

    public static Result someResult4(){
        return Result.builder()
                .player(Player.builder()
                        .name("Tomek")
                        .build())
                .tournament(Tournament.builder()
                        .date(new Date(2024, Calendar.APRIL, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .season(Season.builder()
                                .name("TEST1")
                                .startDate(new Date(2024, Calendar.APRIL, 1))
                                .endDate(new Date(2024, Calendar.MAY,1))
                                .toDelete(false)
                                .rankCount(2)
                                .build())
                        .build())
                .pointsEarned(7)
                .build();
    }

    public static Season someSeason1(){
        return Season.builder()
                .name("TEST1")
                .startDate(new Date(2024, Calendar.JANUARY, 1))
                .endDate(new Date(2024, Calendar.FEBRUARY,1))
                .toDelete(false)
                .tournaments(List.of(Tournament.builder()
                        .date(new Date(2024, Calendar.JANUARY, 11))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .build()))
                .rankCount(2)
                .build();
    }

    public static Tournament someTournament1(){
        return Tournament.builder()
                .date(new Date(2024, Calendar.JANUARY, 11))
                .results(List.of(someResult1(), someResult2()))
                .achievements(List.of(someAchievement1(), someAchievement2()))
                .matches(List.of(someMatch1(), someMatch2()))
                .size(48)
                .active(false)
                .closed(false)
                .season(someSeason1())
                .build();
    }

    public static Tournament someTournament2(){
        return Tournament.builder()
                .date(new Date(2024, Calendar.FEBRUARY, 12))
                .results(List.of(someResult2(), someResult3()))
                .achievements(List.of(someAchievement2(), someAchievement3()))
                .matches(List.of(someMatch2(), someMatch3()))
                .size(48)
                .active(false)
                .closed(false)
                .season(someSeason1())
                .build();
    }

    public static Tournament someTournament3(){
        return Tournament.builder()
                .date(new Date(2024, Calendar.MARCH, 13))
                .results(List.of(someResult3(), someResult4()))
                .achievements(List.of(someAchievement3(), someAchievement4()))
                .matches(List.of(someMatch3(), someMatch4()))
                .size(48)
                .active(false)
                .closed(false)
                .season(someSeason1())
                .build();
    }

    public static Tournament someTournament4(){
        return Tournament.builder()
                .date(new Date(2024, Calendar.APRIL, 14))
                .results(List.of(someResult4(), someResult1()))
                .achievements(List.of(someAchievement4(), someAchievement1()))
                .matches(List.of(someMatch4(), someMatch1()))
                .size(48)
                .active(false)
                .closed(false)
                .season(someSeason1())
                .build();
    }
}
