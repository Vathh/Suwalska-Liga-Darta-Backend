package pl.liga.api.dto.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.liga.api.dto.PlayerSummaryDTO;
import pl.liga.api.dto.SeasonResultsDTO;
import pl.liga.domain.*;

import java.util.*;
import java.util.stream.Collectors;

import static pl.liga.domain.Helpers.*;

@Component
@AllArgsConstructor
public class SeasonResultsMapperImpl {

    private final TournamentMapperImpl tournamentMapperImpl;

    public SeasonResultsDTO map(final Season season){

        List<Tournament> tournaments = season.getTournaments();

        List<PlayerSummaryDTO> playerSummaries = new ArrayList<>();

        Map<Player, List<Result>> resultsMap = tournaments.stream()
                                                .map(Tournament::getResults)
                                                .flatMap(List::stream)
                                                .collect(Collectors.groupingBy(Result::getPlayer));

        Map<Player, List<Achievement>> achievementsMap = tournaments.stream()
                                                            .map(Tournament::getAchievements)
                                                            .flatMap(List::stream)
                                                            .collect(Collectors.groupingBy(Achievement::getPlayer));

        resultsMap.forEach((player, results) -> {
            int rank = results.stream()
                        .map(Result::getPointsEarned)
                        .sorted(Comparator.reverseOrder())
                        .limit(season.getRankCount())
                        .mapToInt(Integer::intValue)
                        .sum();
            int sum = results.stream()
                    .map(Result::getPointsEarned)
                    .mapToInt(Integer::intValue)
                    .sum();
            PlayerSummaryDTO dto = PlayerSummaryDTO.builder()
                    .name(player.getName())
                    .rank(rank)
                    .total(sum)
                    .frequency(results.size())
                    .build();
            playerSummaries.add(dto);
        });

        achievementsMap.forEach((player, achievements) -> {
            if(achievements.size() > 0){
                Map<String, List<Achievement>> achievementsSorted = achievements.stream().collect(Collectors.groupingBy(Achievement::getType));
                PlayerSummaryDTO playerSummaryDTO = playerSummaries.stream().filter(dto -> dto.getName().equals(player.getName()))
                                                                            .findFirst()
                                                                            .orElse(null);

                if(playerSummaryDTO != null){
                    if(achievementsSorted.containsKey(MAX)){
                        playerSummaryDTO.setMax(achievementsSorted.get(MAX).size());
                    }

                    if(achievementsSorted.containsKey(ONESEVENTY)){
                        playerSummaryDTO.setOneSeventy(achievementsSorted.get(ONESEVENTY).size());
                    }

                    if(achievementsSorted.containsKey(HF)){
                        playerSummaryDTO.setHf(achievementsSorted.get(HF).stream().map(Achievement::getValue).max(Comparator.naturalOrder()).orElse(null));
                    }

                    if(achievementsSorted.containsKey(QF)){
                        playerSummaryDTO.setQf(achievementsSorted.get(QF).stream().map(Achievement::getValue).min(Comparator.naturalOrder()).orElse(null));
                    }
                }
            }
        });

        return SeasonResultsDTO.builder()
                .name(season.getName())
                .tournaments(tournaments.stream().map(tournamentMapperImpl::mapWithResults).toList())
                .playerSummaries(playerSummaries)
                .build();
    };


}
