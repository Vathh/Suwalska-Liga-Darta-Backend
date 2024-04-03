CREATE TABLE league_tournament
(
    tournament_id           SERIAL          NOT NULL,
    tournament_date         DATE            NOT NULL,
    closed                  BOOLEAN                 ,
    season_id               INT             NOT NULL,
    PRIMARY KEY (tournament_id),
    CONSTRAINT fk_league_tournament_season
        FOREIGN KEY (season_id)
            REFERENCES league_season (season_id)
);

