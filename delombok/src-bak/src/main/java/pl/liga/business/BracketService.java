package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.liga.domain.*;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@AllArgsConstructor
public class BracketService {

    private final SchemaService schemaService;

    public List<Match> getBracket(List<Player> players, Tournament tournament){

        ArrayList<Integer> randomNumbers = getRandomNumbers(48);
        Map<Integer, Player> playersMap = new HashMap<>();
        players.forEach(player -> playersMap.put(randomNumbers.remove(0), player));

        List<SchemaMatch> schemaMatches = schemaService.getSchemaMatches(players.size());

        List<Match> matches = schemaMatches.stream().map(schemaMatch ->
                Match.builder()
                        .playerA(playersMap.getOrDefault(schemaMatch.getPlayerANumber(), null))
                        .playerB(playersMap.getOrDefault(schemaMatch.getPlayerBNumber(), null))
                        .tournament(tournament)
                        .winner(null)
                        .loser(null)
                        .markup(schemaMatch.getMarkup())
                        .winnerDestinationMarkup(schemaMatch.getWinnerDestinationMarkup())
                        .loserDestinationMarkup(schemaMatch.getLoserDestinationMarkup())
                        .points(schemaMatch.getPoints())
                        .build()
        ).toList();

        return matches;
    };

    public ArrayList<Integer> getRandomNumbers(Integer size){
        ArrayList<Integer> list = new ArrayList<>(size);

        for(int i = 1; i<=size; i++){
          list.add(i);
        }

        Random rand = new Random();
        ArrayList<Integer> result = new ArrayList<>();

        while(list.size() > 0){
          int index = rand.nextInt(list.size());
          result.add(list.remove(index));
        }

        return result;
    };
}
