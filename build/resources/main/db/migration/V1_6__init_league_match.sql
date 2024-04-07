CREATE TABLE league_match
(
    match_id                SERIAL          NOT NULL,
    player_a_id             INT                     ,
    player_b_id             INT                     ,
    winner_id               INT                     ,
    loser_id                INT                     ,
    tournament_id           INT             NOT NULL,
    markup                  VARCHAR(5)      NOT NULL,
    winner_markup           VARCHAR(5)              ,
    loser_markup            VARCHAR(5)              ,
    points                  SMALLINT                ,
    match_active            BOOLEAN         NOT NULL,
    PRIMARY KEY (match_id),
    CONSTRAINT fk_league_48_matches_player_a
        FOREIGN KEY (player_a_id)
            REFERENCES league_player (player_id),
    CONSTRAINT fk_league_48_matches_player_b
        FOREIGN KEY (player_b_id)
            REFERENCES league_player (player_id),
    CONSTRAINT fk_league_48_matches_winner
        FOREIGN KEY (winner_id)
            REFERENCES league_player (player_id),
    CONSTRAINT fk_league_48_matches_loser
        FOREIGN KEY (loser_id)
            REFERENCES league_player (player_id),
    CONSTRAINT fk_league_48_matches_tournament
        FOREIGN KEY (tournament_id)
            REFERENCES league_tournament (tournament_id)
);

