package pl.liga.util;

import pl.liga.domain.AchievementType;
import pl.liga.infrastructure.database.entity.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@SuppressWarnings("deprecation")
public class EntityFixtures {

    public static AchievementEntity someAchievementEntity1(){
        return AchievementEntity.builder()
                .player(PlayerEntity.builder()
                        .name("Andrzej")
                        .build())
                .tournament(TournamentEntity.builder()
                        .date(new Date(2024, Calendar.JANUARY, 1))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .build())
                .type(AchievementType.MAX)
                .value(null)
                .build();
    }

    public static AchievementEntity someAchievementEntity2(){
        return AchievementEntity.builder()
                .player(PlayerEntity.builder()
                        .name("Marian")
                        .build())
                .tournament(TournamentEntity.builder()
                        .date(new Date(2024, Calendar.JANUARY, 1))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .build())
                .type(AchievementType.ONESEVENTY)
                .value(null)
                .build();
    }

    public static MatchEntity someMatchEntity1(){
        return MatchEntity.builder()
                .playerA(PlayerEntity.builder()
                        .name("Andrzej")
                        .build())
                .playerB(PlayerEntity.builder()
                        .name("Marian")
                        .build())
                .winner(PlayerEntity.builder()
                        .name("Andrzej")
                        .build())
                .loser(PlayerEntity.builder()
                        .name("Marian")
                        .build())
                .tournament(TournamentEntity.builder()
                        .date(new Date(2024, Calendar.JANUARY, 1))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .build())
                .markup("PA1")
                .winnerDestinationMarkup("PB1")
                .loserDestinationMarkup("LA1")
                .points(1)
                .active(false)
                .build();
    }

    public static PlayerEntity somePlayerEntity1(){
        return PlayerEntity.builder()
                .name("Andrzej")
                .achievements(Set.of(someAchievementEntity1()))
                .results(Set.of(someResultEntity1()))
                .build();
    }

    public static PlayerEntity somePlayerEntity2(){
        return PlayerEntity.builder()
                .name("Marian")
                .achievements(Set.of(someAchievementEntity2()))
                .results(Set.of(someResultEntity2()))
                .build();
    }

    public static ResultEntity someResultEntity1(){
        return ResultEntity.builder()
                .player(PlayerEntity.builder()
                        .name("Andrzej")
                        .build())
                .tournament(TournamentEntity.builder()
                        .date(new Date(2024, Calendar.JANUARY, 1))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .build())
                .pointsEarned(1)
                .build();
    }

    public static ResultEntity someResultEntity2(){
        return ResultEntity.builder()
                .player(PlayerEntity.builder()
                        .name("Marian")
                        .build())
                .tournament(TournamentEntity.builder()
                        .date(new Date(2024, Calendar.JANUARY, 1))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .build())
                .pointsEarned(3)
                .build();
    }

    public static SchemaMatchEntity someSchemaMatchEntity1(){
        return SchemaMatchEntity.builder()
                .schemaSize(48)
                .playerANumber(1)
                .playerBNumber(2)
                .markup("PA1")
                .winnerDestinationMarkup("PB1")
                .loserDestinationMarkup("LA1")
                .points(1)
                .build();
    }

    public static SeasonEntity someSeasonEntity1(){
        return SeasonEntity.builder()
                .name("TEST1")
                .startDate(new Date(2024, Calendar.JANUARY, 1))
                .endDate(new Date(2024, Calendar.FEBRUARY, 1))
                .toDelete(false)
                .tournaments(Set.of(TournamentEntity.builder()
                        .date(new Date(2024, Calendar.JANUARY, 1))
                        .size(48)
                        .active(false)
                        .closed(false)
                        .build()))
                .rankCount(1)
                .build();
    }

    public static TournamentEntity someTournamentEntity1(){
        return TournamentEntity.builder()
                .date(new Date(2024, Calendar.JANUARY, 1))
                .results(Set.of(someResultEntity1()))
                .achievements(Set.of(someAchievementEntity1()))
                .matches(Set.of(someMatchEntity1()))
                .size(48)
                .active(false)
                .closed(false)
                .season(someSeasonEntity1())
                .build();
    }
}
