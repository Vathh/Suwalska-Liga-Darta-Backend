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

        ArrayList<Integer> randomNumbers = getRandomNumbers(players.size());
        Map<Integer, Player> playersMap = new HashMap<>();
        players.forEach(player -> playersMap.put(randomNumbers.remove(0), player));

        Player emptyPlayer = Player.builder()
                .playerId(1)
                .name("EMPTY")
                .build();

        while(randomNumbers.size() > 0){
            playersMap.put(randomNumbers.remove(0), emptyPlayer);
        }

        List<SchemaMatch> schemaMatches = schemaService.getSchemaMatches(players.size());

        List<Match> matches = new ArrayList<>(schemaMatches.stream().map(schemaMatch ->
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
                        .active(true)
                        .build()
        ).toList());

        for(Match match : matches){
            handleEmptyMatch(match, matches);
        }

        return matches;
    };


    public ArrayList<Integer> getRandomNumbers(Integer size){

        int numbersCount = 0;
        if(size > 32 && size <= 48){
            numbersCount = 48;
        } else if (size <= 32 && size > 16) {
            numbersCount = 32;
        } else if (size <= 16 && size > 8) {
            numbersCount = 16;
        }else {
            numbersCount = 16;
        }

        ArrayList<Integer> list = new ArrayList<>(numbersCount);

        for(int i = 1; i<=numbersCount; i++){
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

    private void handleEmptyMatch(Match match, List<Match> matches){
        if(match.getPlayerA() != null && match.getPlayerA().getName().equals("EMPTY") && match.getPlayerB() != null){
            match.setWinner(match.getPlayerB());
            match.setLoser(match.getPlayerA());
            match.setActive(false);

            moveWinnerToNextMatch(match, matches);
            moveLoserToNextMatch(match, matches);
        } else if(match.getPlayerB() != null && match.getPlayerB().getName().equals("EMPTY") && match.getPlayerA() != null){
            match.setWinner(match.getPlayerA());
            match.setLoser(match.getPlayerB());
            match.setActive(false);

            moveWinnerToNextMatch(match, matches);
            moveLoserToNextMatch(match, matches);
        }
    }

    private void moveWinnerToNextMatch(Match match, List<Match> matches){
        String winnerDestinationMarkup = match.getWinnerDestinationMarkup();

        for(Match nextMatch : matches){
            if(winnerDestinationMarkup.equals(nextMatch.getMarkup())){
                if(nextMatch.getPlayerA() == null){
                    nextMatch.setPlayerA(match.getWinner());
                } else {
                    nextMatch.setPlayerB(match.getWinner());
                }
                break;
            }
        }
    }

    private void moveLoserToNextMatch(Match match, List<Match> matches){

        String loserDestinationMarkup = match.getLoserDestinationMarkup();

        if(loserDestinationMarkup == null){
            return;
        }

        for(Match nextMatch : matches){
            if(loserDestinationMarkup.equals(nextMatch.getMarkup())){
                if(nextMatch.getPlayerA() == null){
                    nextMatch.setPlayerA(match.getLoser());
                } else {
                    nextMatch.setPlayerB(match.getLoser());
                }
                break;
            }
        }
    }
}
