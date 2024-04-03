CREATE TABLE league_schema_match
(
    schema_match_id         SERIAL                 NOT NULL,
    schema_size             SMALLINT               NOT NULL,
    player_a_number         SMALLINT                       ,
    player_b_number         SMALLINT                       ,
    markup                  VARCHAR(5)             NOT NULL,
    winner_markup           VARCHAR(5)                     ,
    loser_markup            VARCHAR(5)                     ,
    points                  SMALLINT                       ,
    PRIMARY KEY (schema_match_id)
);

