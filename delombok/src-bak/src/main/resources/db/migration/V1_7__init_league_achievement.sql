CREATE TABLE league_achievement
(
    achievement_id          SERIAL          NOT NULL,
    player_id               INT             NOT NULL,
    tournament_id           INT             NOT NULL,
    achievement_type        VARCHAR(8)      NOT NULL,
    achievement_value       INT                     ,
    PRIMARY KEY (achievement_id),
    CONSTRAINT fk_league_achievement_tournament
        FOREIGN KEY (tournament_id)
            REFERENCES league_achievement (achievement_id),
    CONSTRAINT fk_league_achievement_player
        FOREIGN KEY (player_id)
            REFERENCES league_player (player_id)
);