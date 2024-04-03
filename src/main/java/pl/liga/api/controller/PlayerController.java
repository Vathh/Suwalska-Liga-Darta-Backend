package pl.liga.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.liga.api.dto.PlayerDTO;
import pl.liga.api.dto.mapper.PlayerMapper;
import pl.liga.business.PlayerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(PlayerController.PLAYER)
public class PlayerController {

    public static final String PLAYER = "/player";
    public static final String PLAYER_DETAILS = "/details";

    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    @GetMapping
    public List<PlayerDTO> getPlayers(){
        return playerService.findAllWithAchievementsAndResults()
                .stream()
                .map(playerMapper::map)
                .toList();
    }

    @GetMapping(PLAYER_DETAILS)
    public List<PlayerDTO> getSpecifiedPlayers(){
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        return playerService.findPlayersByIdsWithoutResultsAndAchievements(list).stream().map(playerMapper::map).toList();
    }

    @PostMapping
    public ResponseEntity<?> addPlayer(
            @Valid @RequestBody PlayerDTO playerDTO
    ){
        playerService.addPlayer(playerMapper.map(playerDTO));

        return ResponseEntity.ok().build();
    }
}
