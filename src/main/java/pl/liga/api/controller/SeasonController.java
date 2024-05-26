package pl.liga.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.liga.api.dto.SeasonDTO;
import pl.liga.api.dto.SeasonResultsDTO;
import pl.liga.api.dto.mapper.SeasonMapper;
import pl.liga.api.dto.mapper.SeasonResultsMapperImpl;
import pl.liga.business.SeasonService;
import pl.liga.domain.Season;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(SeasonController.SEASON)
public class SeasonController {

    public static final String SEASON = "/season";
    public static final String SEASON_DETAILS = "/details";

    private final SeasonService seasonService;
    private final SeasonMapper seasonMapper;
    private final SeasonResultsMapperImpl seasonResultsMapper;

    @GetMapping
    public List<SeasonDTO> getSeasons(){
        return seasonService
                .findAll()
                .stream()
                .map(seasonMapper::map)
                .toList();
    }

    @GetMapping(SEASON_DETAILS)
    public SeasonResultsDTO getSeasonResults(
            @RequestParam("seasonId") Integer seasonId
    ){
        Season season = seasonService.findBySeasonId(seasonId);

        return seasonResultsMapper.map(season);
    }

    @DeleteMapping(SEASON_DETAILS)
    public void deleteSeason(
            @RequestParam("seasonId") Integer seasonId
    ){
        seasonService.deleteSeason(seasonId);
    }

    @PostMapping
    public ResponseEntity<?> addSeason(
            @Valid @RequestBody SeasonDTO seasonDTO
            ){
        Season season = seasonMapper.map(seasonDTO);

        seasonService.addSeason(season);

        return ResponseEntity.ok().build();
    }
}
