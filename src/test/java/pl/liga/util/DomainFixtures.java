package pl.liga.util;

import pl.liga.domain.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
public class DomainFixtures {

    public static Achievement someAchievement1(){
        return Achievement.builder()
                .player(somePlayer1())
                .tournament(someTournament1())
                .type(AchievementType.MAX)
                .value(null)
                .build();
    }

    public static Achievement someAchievement2(){
        return Achievement.builder()
                .player(somePlayer2())
                .tournament(someTournament2())
                .type(AchievementType.ONESEVENTY)
                .value(171)
                .build();
    }

    public static Achievement someAchievement3(){
        return Achievement.builder()
                .player(somePlayer3())
                .tournament(someTournament3())
                .type(AchievementType.HF)
                .value(151)
                .build();
    }

    public static Achievement someAchievement4(){
        return Achievement.builder()
                .player(somePlayer4())
                .tournament(someTournament4())
                .type(AchievementType.QF)
                .value(19)
                .build();
    }

    public static Match someMatch1(){
        return Match.builder()
                .playerA(somePlayer1())
                .playerB(somePlayer2())
                .winner(somePlayer1())
                .loser(somePlayer2())
                .tournament(someTournament1())
                .markup("PA1")
                .winnerDestinationMarkup("PB1")
                .loserDestinationMarkup("LA1")
                .points(null)
                .active(true)
                .build();
    }

    public static Match someMatch2(){
        return Match.builder()
                .playerA(somePlayer2())
                .playerB(somePlayer3())
                .winner(somePlayer2())
                .loser(somePlayer3())
                .tournament(someTournament2())
                .markup("PA2")
                .winnerDestinationMarkup("PB2")
                .loserDestinationMarkup("LA2")
                .points(null)
                .active(true)
                .build();
    }

    public static Match someMatch3(){
        return Match.builder()
                .playerA(somePlayer3())
                .playerB(somePlayer4())
                .winner(somePlayer3())
                .loser(somePlayer4())
                .tournament(someTournament3())
                .markup("PA3")
                .winnerDestinationMarkup("PB3")
                .loserDestinationMarkup("LA3")
                .points(null)
                .active(true)
                .build();
    }

    public static Match someMatch4(){
        return Match.builder()
                .playerA(somePlayer4())
                .playerB(somePlayer2())
                .winner(somePlayer2())
                .loser(somePlayer4())
                .tournament(someTournament4())
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
                .achievements(List.of(someAchievement1(), someAchievement2()))
                .results(List.of(someResult1(), someResult2()))
                .build();
    }

    public static Player somePlayer2(){
        return Player.builder()
                .name("Marian")
                .achievements(List.of(someAchievement2(), someAchievement3()))
                .results(List.of(someResult2(), someResult3()))
                .build();
    }

    public static Player somePlayer3(){
        return Player.builder()
                .name("Maciej")
                .achievements(List.of(someAchievement3(), someAchievement4()))
                .results(List.of(someResult3(), someResult4()))
                .build();
    }

    public static Player somePlayer4(){
        return Player.builder()
                .name("Tomek")
                .achievements(List.of(someAchievement4(), someAchievement1()))
                .results(List.of(someResult4(), someResult1()))
                .build();
    }

    public static Result someResult1(){
        return Result.builder()
                .player(somePlayer1())
                .tournament(someTournament1())
                .pointsEarned(1)
                .build();
    }

    public static Result someResult2(){
        return Result.builder()
                .player(somePlayer1())
                .tournament(someTournament2())
                .pointsEarned(3)
                .build();
    }

    public static Result someResult3(){
        return Result.builder()
                .player(somePlayer1())
                .tournament(someTournament3())
                .pointsEarned(5)
                .build();
    }

    public static Result someResult4(){
        return Result.builder()
                .player(somePlayer1())
                .tournament(someTournament4())
                .pointsEarned(7)
                .build();
    }

    public static Season someSeason1(){
        return Season.builder()
                .name("TEST1")
                .startDate(new Date(2024, Calendar.JANUARY, 1))
                .endDate(new Date(2024, Calendar.FEBRUARY,1))
                .toDelete(false)
                .tournaments(List.of(someTournament1(), someTournament2()))
                .rankCount(2)
                .build();
    }

    public static Season someSeason2(){
        return Season.builder()
                .name("TEST2")
                .startDate(new Date(2024, Calendar.FEBRUARY, 2))
                .endDate(new Date(2024, Calendar.MARCH,2))
                .toDelete(false)
                .tournaments(List.of(someTournament2(), someTournament3()))
                .rankCount(2)
                .build();
    }

    public static Season someSeason3(){
        return Season.builder()
                .name("TEST3")
                .startDate(new Date(2024, Calendar.MARCH, 3))
                .endDate(new Date(2024, Calendar.APRIL,3))
                .toDelete(false)
                .tournaments(List.of(someTournament3(), someTournament4()))
                .rankCount(2)
                .build();
    }

    public static Season someSeason4(){
        return Season.builder()
                .name("TEST4")
                .startDate(new Date(2024, Calendar.APRIL, 4))
                .endDate(new Date(2024, Calendar.MAY,4))
                .toDelete(false)
                .tournaments(List.of(someTournament4(), someTournament1()))
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
                .season(someSeason2())
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
                .season(someSeason3())
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
                .season(someSeason4())
                .build();
    }
}
