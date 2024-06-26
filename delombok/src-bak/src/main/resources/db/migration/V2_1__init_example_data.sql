insert into league_player (player_name) values
('Maciek P'),
('Damian'),
('Maciek'),
('Wojtek'),
('Pawel'),
('Kuba M'),
('Kucza'),
('Rafko'),
('Dario'),
('Filip'),
('Tomek P'),
('Łuki'),
('Miras'),
('Jarek'),
('Piotr'),
('Gienek'),
('Kuba'),
('Słowik'),
('Rafał W'),
('Rosół'),
('Mateusz'),
('Strażak'),
('Szaher'),
('Gnatek'),
('Sławek'),
('Kamil'),
('Marian'),
('Tomek R'),
('Krzysiek'),
('Rogal'),
('Maroni'),
('Artur'),
('Asia'),
('Dawid'),
('Joana'),
('Nela');

insert into league_season (season_name, start_date, end_date) values
('Jesień 2023', '2023-09-01', '2023-12-22');

insert into league_tournament (tournament_date, closed, season_id) values
('2023-09-01', true, 1),
('2023-09-08', true, 1),
('2023-09-15', true, 1),
('2023-09-22', true, 1),
('2023-09-29', true, 1),
('2023-10-06', true, 1),
('2023-10-13', true, 1),
('2023-10-20', true, 1),
('2023-10-27', true, 1),
('2023-11-03', true, 1),
('2023-11-10', true, 1),
('2023-11-17', true, 1),
('2023-11-24', true, 1),
('2023-12-01', true, 1),
('2023-12-08', true, 1),
('2023-12-15', true, 1),
('2023-12-22', true, 1);

insert into league_result (player_id, tournament_id, points_earned) values
(1, 1, 3),
(1, 2, 3),
(1, 3, 4),
(1, 4, 3),
(1, 5, 5),
(1, 6, 1),
(1, 7, 5),
(1, 8, 2),
(1, 9, 3),
(1, 10, 5),
(1, 11, 2),
(1, 12, 8),
(1, 13, 3),
(1, 14, 1),
(1, 15, 3),
(1, 16, 1),
(1, 17, 5),

(11, 1, 30),
(11, 2, 30),
(11, 3, 25),
(11, 4, 25),
(11, 5, 30),
(11, 6, 30),
(11, 7, 30),
(11, 8, 25),
(11, 9, 15),
(11, 12, 25),
(11, 13, 30),
(11, 17, 12),

(12, 1, 9),
(12, 2, 12),
(12, 3, 12),
(12, 4, 21),
(12, 5, 19),
(12, 6, 21),
(12, 7, 15),
(12, 8, 8),
(12, 9, 9),
(12, 10, 9),
(12, 11, 10),
(12, 12, 20),
(12, 13, 9),
(12, 14, 21),
(12, 15, 12),
(12, 16, 15),
(12, 17, 15);

insert into league_schema_match (schema_size, player_a_number, player_b_number, markup, winner_markup, loser_markup, points) values
(48, 32,    48,     'PA1',  'PB1',  'LA1',  null),
(48, 16,    33,     'PA2',  'PB2',  'LA2',  null),
(48, 24,    40,     'PA3',  'PB3',  'LA3',  null),
(48, 8,     41,     'PA4',  'PB4',  'LA4',  null),
(48, 28,    44,     'PA5',  'PB5',  'LA5',  null),
(48, 12,    37,     'PA6',  'PB6',  'LA6',  null),
(48, 20,    36,     'PA7',  'PB7',  'LA7',  null),
(48, 29,    45,     'PA8',  'PB8',  'LA8',  null),
(48, 30,    46,     'PA9',  'PB9',  'LA9',  null),
(48, 14,    35,     'PA10', 'PB10', 'LA10', null),
(48, 22,    38,     'PA11', 'PB11', 'LA11', null),
(48, 6,     43,     'PA12', 'PB12', 'LA12', null),
(48, 26,    42,     'PA13', 'PB13', 'LA13', null),
(48, 10,    39,     'PA14', 'PB14', 'LA14', null),
(48, 18,    34,     'PA15', 'PB15', 'LA15', null),
(48, 31,    47,     'PA16', 'PB16', 'LA16', null),

(48, 1,     null,   'PB1',  'PC1',  'LA16', null),
(48, 17,    null,   'PB2',  'PC2',  'LA15', null),
(48, 9,     null,   'PB3',  'PC3',  'LA14', null),
(48, 25,    null,   'PB4',  'PC4',  'LA13', null),
(48, 5,     null,   'PB5',  'PC5',  'LA12', null),
(48, 21,    null,   'PB6',  'PC6',  'LA11', null),
(48, 13,    null,   'PB7',  'PC7',  'LA10', null),
(48, 4,     null,   'PB8',  'PC8',  'LA9',  null),
(48, 3,     null,   'PB9',  'PC9',  'LA8',  null),
(48, 19,    null,   'PB10', 'PC10', 'LA7',  null),
(48, 11,    null,   'PB11', 'PC11', 'LA6',  null),
(48, 27,    null,   'PB12', 'PC12', 'LA5',  null),
(48, 7,     null,   'PB13', 'PC13', 'LA4',  null),
(48, 23,    null,   'PB14', 'PC14', 'LA3',  null),
(48, 15,    null,   'PB15', 'PC15', 'LA2',  null),
(48, 2,     null,   'PB16', 'PC16', 'LA1',  null),

(48, null,    null,   'PC1',  'PD1',  'LC4',  null),
(48, null,    null,   'PC2',  'PD1',  'LC3',  null),
(48, null,    null,   'PC3',  'PD2',  'LC2',  null),
(48, null,    null,   'PC4',  'PD2',  'LC1',  null),
(48, null,    null,   'PC5',  'PD3',  'LC8',  null),
(48, null,    null,   'PC6',  'PD3',  'LC7',  null),
(48, null,    null,   'PC7',  'PD4',  'LC6',  null),
(48, null,    null,   'PC8',  'PD4',  'LC5',  null),

(48, null,    null,   'PD1',  'PE1',  'LE3',  null),
(48, null,    null,   'PD2',  'PE1',  'LE4',  null),
(48, null,    null,   'PD3',  'PE2',  'LE1',  null),
(48, null,    null,   'PD4',  'PE2',  'LE2',  null),

(48, null,    null,   'PE1',  'PF1',  'LG1',  null),
(48, null,    null,   'PE2',  'PF1',  'LG2',  null),

(48, null,    null,   'PF1',  'PG1',  'LI1',  null),

(48, null,    null,   'PG1',  'PH1',  'PH1',  null),

(48, null,    null,   'PH1',  null,  null,  25),


(48, null,    null,   'LA1',  'LB1', null,   1),
(48, null,    null,   'LA2',  'LB1', null,   1),
(48, null,    null,   'LA3',  'LB2', null,   1),
(48, null,    null,   'LA4',  'LB2', null,   1),
(48, null,    null,   'LA5',  'LB3', null,   1),
(48, null,    null,   'LA6',  'LB3', null,   1),
(48, null,    null,   'LA7',  'LB4', null,   1),
(48, null,    null,   'LA8',  'LB4', null,   1),
(48, null,    null,   'LA9',  'LB5', null,   1),
(48, null,    null,   'LA10', 'LB5', null,   1),
(48, null,    null,   'LA11', 'LB6', null,   1),
(48, null,    null,   'LA12', 'LB6', null,   1),
(48, null,    null,   'LA13', 'LB7', null,   1),
(48, null,    null,   'LA14', 'LB7', null,   1),
(48, null,    null,   'LA15', 'LB8', null,   1),
(48, null,    null,   'LA16', 'LB8', null,   1),

(48, null,    null,   'LB1',  'LC1',  null,  3),
(48, null,    null,   'LB2',  'LC2',  null,  3),
(48, null,    null,   'LB3',  'LC3',  null,  3),
(48, null,    null,   'LB4',  'LC4',  null,  3),
(48, null,    null,   'LB5',  'LC5',  null,  3),
(48, null,    null,   'LB6',  'LC6',  null,  3),
(48, null,    null,   'LB7',  'LC7',  null,  3),
(48, null,    null,   'LB8',  'LC8',  null,  3),

(48, null,    null,   'LC1',  'LD1',  null,   5),
(48, null,    null,   'LC2',  'LD1',  null,   5),
(48, null,    null,   'LC3',  'LD2',  null,   5),
(48, null,    null,   'LC4',  'LD2',  null,   5),
(48, null,    null,   'LC5',  'LD3',  null,   5),
(48, null,    null,   'LC6',  'LD3',  null,   5),
(48, null,    null,   'LC7',  'LD4',  null,   5),
(48, null,    null,   'LC8',  'LD4',  null,   5),

(48, null,    null,   'LD1',  'LE1',  null,   7),
(48, null,    null,   'LD2',  'LE2',  null,   7),
(48, null,    null,   'LD3',  'LE3',  null,   7),
(48, null,    null,   'LD4',  'LE4',  null,   7),

(48, null,    null,   'LE1',  'LF1',  null,   9),
(48, null,    null,   'LE2',  'LF1',  null,   9),
(48, null,    null,   'LE3',  'LF2',  null,   9),
(48, null,    null,   'LE4',  'LF2',  null,   9),

(48, null,    null,   'LF1',  'LG1',  null,   12),
(48, null,    null,   'LF2',  'LG2',  null,   12),

(48, null,    null,   'LG1',  'LH1',  null,   15),
(48, null,    null,   'LG2',  'LH1',  null,   15),

(48, null,    null,   'LH1',  'LI1',  null,   18),

(48, null,    null,   'LI1',  'PG1',  null,   21);
