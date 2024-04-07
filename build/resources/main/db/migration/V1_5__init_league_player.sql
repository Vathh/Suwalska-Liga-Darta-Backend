CREATE TABLE league_player
(
    player_id               SERIAL          NOT NULL,
    player_name             VARCHAR(20)     NOT NULL,
    PRIMARY KEY (player_id),
    UNIQUE (player_name)
);