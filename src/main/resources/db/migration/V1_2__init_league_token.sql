CREATE TABLE league_token
(
    token_id           SERIAL          NOT NULL,
    token              VARCHAR(255)    NOT NULL,
    user_id            INT             NOT NULL,
    token_type         VARCHAR(255)    NOT NULL,
    expired            BOOLEAN         NOT NULL,
    revoked            BOOLEAN         NOT NULL,
    PRIMARY KEY (token_id),
    CONSTRAINT fk_league_token_user
        FOREIGN KEY (user_id)
            REFERENCES league_user (user_id)
);

