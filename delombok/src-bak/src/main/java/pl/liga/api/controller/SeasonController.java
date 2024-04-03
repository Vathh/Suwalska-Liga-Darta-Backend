package pl.liga.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.liga.api.dto.SeasonDTO;
import pl.liga.api.dto.mapper.SeasonMapper;
import pl.liga.business.SeasonService;
import pl.liga.domain.Season;
import pl.liga.domain.Tournament;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(SeasonController.SEASON)
public class SeasonController {

    public static final String SEASON = "/season";

    private final SeasonService seasonService;

    private final SeasonMapper seasonMapper;

    @GetMapping
    public List<SeasonDTO> getSeasons(){
        return seasonService
                .findAllSeasons()
                .stream()
                .map(seasonMapper::map)
                .toList();
    }

    @PostMapping
    public ResponseEntity<?> addSeason(
            @Valid @RequestBody SeasonDTO seasonDTO
            ){
        Season season = seasonMapper.map(seasonDTO);
        List<Tournament> tournaments = season.getTournaments();
        tournaments.forEach(tournament -> tournament.withSeason(season));

        Season seasonToAdd = season.withTournaments(tournaments);
        seasonService.addSeason(seasonToAdd);

        return ResponseEntity.ok().build();
    }
}
