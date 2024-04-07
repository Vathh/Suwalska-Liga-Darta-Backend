CREATE TABLE league_tournament
(
    tournament_id           SERIAL          NOT NULL,
    tournament_date         DATE            NOT NULL,
    tournament_size         INT                     ,
    tournament_active       BOOLEAN                 ,
    closed                  BOOLEAN                 ,
    season_id               INT             NOT NULL,
    PRIMARY KEY (tournament_id),
    CONSTRAINT fk_league_tournament_season
        FOREIGN KEY (season_id)
            REFERENCES league_season (season_id)
);

