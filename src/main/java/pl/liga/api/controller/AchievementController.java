package pl.liga.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.liga.api.dto.MatchAchievementsDTO;
import pl.liga.business.AchievementService;

@RestController
@AllArgsConstructor
@RequestMapping(AchievementController.ACHIEVEMENT)
public class AchievementController {

    public static final String ACHIEVEMENT = "/achievement";

    private final AchievementService achievementService;

    @PostMapping
    public ResponseEntity<?> addAchievements(
            @Valid @RequestBody MatchAchievementsDTO matchAchievementsDTO
            ){

        achievementService.addAchievements(matchAchievementsDTO);

        return ResponseEntity.ok().build();
    }
}
