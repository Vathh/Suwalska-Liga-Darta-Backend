CREATE TABLE league_schema_match
(
    schema_match_id         SERIAL                 NOT NULL,
    schema_size             SMALLINT               NOT NULL,
    player_a_number         SMALLINT                       ,
    player_b_number         SMALLINT                       ,
    markup                  VARCHAR(4)             NOT NULL,
    winner_markup           VARCHAR(4)                     ,
    loser_markup            VARCHAR(4)                     ,
    points                  SMALLINT                       ,
    PRIMARY KEY (schema_match_id)
);

