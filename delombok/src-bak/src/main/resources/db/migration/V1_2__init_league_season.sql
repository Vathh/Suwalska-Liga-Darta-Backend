CREATE TABLE league_season
(
    season_id         SERIAL          NOT NULL,
    season_name       VARCHAR(30)     NOT NULL,
    start_date        DATE            NOT NULL,
    end_date          DATE            NOT NULL,
    PRIMARY KEY (season_id)
);