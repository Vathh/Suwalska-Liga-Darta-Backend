CREATE TABLE league_role(
  role_id SERIAL NOT NULL,
  role VARCHAR(20) NOT NULL,
  PRIMARY KEY (role_id)
);

CREATE TABLE league_user_role(
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id, role_id),
  CONSTRAINT fk_league_user_role_user
    FOREIGN KEY (user_id)
      REFERENCES league_user (user_id),
  CONSTRAINT fk_league_user_role_role
    FOREIGN KEY (role_id)
      REFERENCES league_role (role_id)
);