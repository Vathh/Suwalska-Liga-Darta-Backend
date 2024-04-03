package pl.liga.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.liga.business.MatchService;
import pl.liga.business.PlayerService;
import pl.liga.business.TournamentService;

@RestController
@AllArgsConstructor
@RequestMapping(TournamentController.TOURNAMENT)
public class TournamentController {

    static final String TOURNAMENT = "/tournament";

}
