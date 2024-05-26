package pl.liga.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.liga.api.dto.*;
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
    public List<TournamentWithoutResultsDTO> getTournamentsWithoutResults(){
        return tournamentService.findAll()
                .stream()
                .map(tournamentMapper::mapWithoutResults)
                .toList();
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

    @GetMapping(TOURNAMENT_ACTIVE)
    public TournamentDTO getActiveTournament(){
        Tournament tournament = tournamentService.findActiveTournament();
        if(tournament == null){
            return null;
        }
        return tournamentMapper.mapToDTO(tournament);
    }

    @GetMapping(TOURNAMENT_DETAILS)
    public TournamentWithResultsAndAchievementsDTO getTournamentResults(
            @RequestParam("tournamentId") Integer tournamentId
    ){
        Tournament tournament = tournamentService.getTournamentByIdWithResults(tournamentId);

        return tournamentMapper.mapWithResultsAndAchievements(tournament);
    }

    @DeleteMapping(TOURNAMENT_DETAILS)
    public ResponseEntity<?> deleteTournament(
            @RequestParam("tournamentId") Integer tournamentId
    ){

        tournamentService.deleteTournament(tournamentId);

        return ResponseEntity.ok().build();
    }

    @PatchMapping(TOURNAMENT_DETAILS)
    public ResponseEntity<?> cancelActiveTournament(
            @RequestParam("tournamentId") Integer tournamentId
    ){
        tournamentService.cancelActiveTournament(tournamentId);


        return ResponseEntity.ok().build();
    }
}
