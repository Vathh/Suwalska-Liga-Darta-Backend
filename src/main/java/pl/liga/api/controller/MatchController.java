package pl.liga.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.liga.api.dto.MatchDTO;
import pl.liga.api.dto.MatchResultDTO;
import pl.liga.api.dto.mapper.MatchMapperImpl;
import pl.liga.business.MatchService;
import pl.liga.domain.Match;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(MatchController.MATCH)
public class MatchController {

    public static final String MATCH = "/match";
    public static final String MATCH_DETAILS = "/details";
    public static final String MATCH_ACTIVE = "/active";

    private final MatchService matchService;
    private final MatchMapperImpl matchMapper;

    @GetMapping
    public List<MatchDTO> getMatchesByTournamentId(
            @RequestParam("tournamentId") Integer tournamentId
    ){
        List<Match> matches = matchService.findMatchesByTournamentId(tournamentId);

        return matches.stream().map(matchMapper::map).toList();
    }

    @GetMapping(MATCH_ACTIVE)
    public List<MatchDTO> getActiveMatches(){
        List<Match> matches = matchService.findActiveMatches();

        return matches.stream().map(matchMapper::map).toList();
    }

    @PatchMapping(MATCH_DETAILS)
    public ResponseEntity<?> updateMatch(
            @Valid @RequestBody MatchResultDTO dto
    ){
        matchService.addMatchResult(dto);

        return ResponseEntity.ok().build();
    }

}
