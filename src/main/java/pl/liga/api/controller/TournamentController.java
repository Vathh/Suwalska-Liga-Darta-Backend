package pl.liga.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.liga.api.dto.StartTournamentDTO;
import pl.liga.api.dto.TournamentDTO;
import pl.liga.api.dto.TournamentWithoutAchievementsResultsMatchesDTO;
import pl.liga.api.dto.TournamentWithoutMatchesDTO;
import pl.liga.api.dto.mapper.TournamentMapperImpl;
import pl.liga.business.TournamentService;
import pl.liga.domain.Tournament;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(TournamentController.TOURNAMENT)
public class TournamentController {

    static final String TOURNAMENT = "/tournament";
    static final String TOURNAMENT_DETAILS = "/details";
    static final String TOURNAMENT_ACTIVE = "/active";
    static final String TOURNAMENT_START = "/start";

    private final TournamentService tournamentService;
    private final TournamentMapperImpl tournamentMapper;

    @GetMapping
    public List<TournamentWithoutAchievementsResultsMatchesDTO> getTournamentsWithoutResults(){
        return tournamentService.findAllWithoutResultsAchievementsMatches()
                .stream()
                .map(tournamentMapper::mapWithoutResults)
                .toList();
    }
    @GetMapping(TOURNAMENT_ACTIVE)
    public TournamentDTO getActiveTournament(){
        Tournament tournament = tournamentService.findActiveTournament();
        if(tournament == null){
            return null;
        }
        return tournamentMapper.mapToDTO(tournament);
    }
    @GetMapping(TOURNAMENT_DETAILS)
    public TournamentWithoutMatchesDTO getTournamentResults(
            @RequestParam("tournamentId") Integer tournamentId
    ){
        Tournament tournament = tournamentService.findByIdWithoutMatches(tournamentId);

        return tournamentMapper.mapWithResultsAndAchievements(tournament);
    }

    @PatchMapping(TOURNAMENT_START)
    public ResponseEntity<?> startTournament(
            @Valid @RequestBody StartTournamentDTO dto
    ){
        if(tournamentService.findActiveTournament() != null){
            return ResponseEntity.badRequest().body("Aktualnie inny turniej jest aktywny.");
        }

        tournamentService.startTournament(dto);

        return ResponseEntity.ok().build();
    }

    @PatchMapping(TOURNAMENT_DETAILS)
    public ResponseEntity<?> cancelActiveTournament(
            @RequestParam("tournamentId") Integer tournamentId
    ){
        tournamentService.cancelActiveTournament(tournamentId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(TOURNAMENT_DETAILS)
    public ResponseEntity<?> deleteTournament(
            @RequestParam("tournamentId") Integer tournamentId
    ){
        tournamentService.deleteTournament(tournamentId);

        return ResponseEntity.ok().build();
    }

}
