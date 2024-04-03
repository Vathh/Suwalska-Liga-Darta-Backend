CREATE TABLE league_result
(
    result_id               SERIAL          NOT NULL,
    player_id               INT             NOT NULL,
    tournament_id           INT             NOT NULL,
    points_earned           SMALLINT        NOT NULL,
    PRIMARY KEY (result_id),
    CONSTRAINT fk_league_result_tournament
        FOREIGN KEY (tournament_id)
            REFERENCES league_tournament (tournament_id),
    CONSTRAINT fk_league_result_player
        FOREIGN KEY (player_id)
            REFERENCES league_player (player_id)
);