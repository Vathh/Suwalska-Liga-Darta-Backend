CREATE TABLE league_user
(
    user_id           SERIAL          NOT NULL,
    user_name         VARCHAR(100)    NOT NULL,
    user_password     VARCHAR(255)    NOT NULL,
    user_role         VARCHAR(255)    NOT NULL,
    PRIMARY KEY (user_id)
);
