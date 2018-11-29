-- The Secret of Monkey Island
INSERT INTO GAMES.GAME("ID", "TITLE", "DESCRIPTIONHTML", "COVER", "SCREENSHOT") VALUES (1, 'The Secret Of Monkey Island', '<p>The Secret of Monkey Island is a 1990 point-and-click graphic adventure game developed and published by Lucasfilm Games. It takes place in a fantastic version of the Caribbean during the age of piracy. The player assumes the role of Guybrush Threepwood, a young man who dreams of becoming a pirate and explores fictional islands while solving puzzles.</p>', 'https://upload.wikimedia.org/wikipedia/en/a/a8/The_Secret_of_Monkey_Island_artwork.jpg', 'https://upload.wikimedia.org/wikipedia/en/9/9f/The_Secret_of_Monkey_Island_SCUMM_Bar.jpg');
INSERT INTO DETAILS.DETAIL("ID", "DIRECTOR", "YEAR", "TYPE", "PUBLISHER") VALUES (1, 'Ron Gilbert', 1990, 'Graphic Adventure', 'Lucasfilm Games');
INSERT INTO REVIEWS.REVIEW("ID", "REVIEW", "REVIEWER", "RATING", "GAMEID") VALUES (1, 'This game is awesome but some puzzles are so hard to resolve', 'Alex', 4, 1);

-- Monkey Island 2: LeChuck's Revenge
INSERT INTO GAMES.GAME("ID", "TITLE", "DESCRIPTIONHTML", "COVER", "SCREENSHOT") VALUES (2, 'Monkey Island 2: LeChuck''s Revenge', '<p>The game''s story centers on the wannabe pirate Guybrush Threepwood. After defeating ghost pirate LeChuck in The Secret of Monkey Island, little is known of what happened between Guybrush Threepwood and Elaine Marley. The sequel involves Guybrush s attempts to find the mysterious treasure of Big Whoop.</p>', 'https://upload.wikimedia.org/wikipedia/en/1/1c/LeChuck%27s_Revenge_artwork.jpg', 'https://upload.wikimedia.org/wikipedia/en/8/82/Monkey_island_2_prison.png');
INSERT INTO DETAILS.DETAIL("ID", "DIRECTOR", "YEAR", "TYPE", "PUBLISHER") VALUES (2, 'Ron Gilbert', 1991, 'Graphic Adventure', 'LucasArts');
INSERT INTO REVIEWS.REVIEW("ID", "REVIEW", "REVIEWER", "RATING", "GAMEID") VALUES (2, 'This game is perfect', 'Alex', 5, 2);

-- Indiana Jones and the Fate of Atlantis
INSERT INTO GAMES.GAME("ID", "TITLE", "DESCRIPTIONHTML", "COVER", "SCREENSHOT") VALUES (3, 'Indiana Jones and the Fate of Atlantis', '<p>The plot is set in the fictional Indiana Jones universe and revolves around the eponymous protagonist''s global search for the legendary sunken city of Atlantis. Sophia Hapgood, an old co-worker of Indiana Jones who gave up her archaeological career to become a psychic, supports him along the journey.</p>', 'https://upload.wikimedia.org/wikipedia/en/4/4d/Fate_of_Atlantis_artwork.jpg', 'https://upload.wikimedia.org/wikipedia/en/6/65/Indy_foa_screenshot.png');
INSERT INTO DETAILS.DETAIL("ID", "DIRECTOR", "YEAR", "TYPE", "PUBLISHER") VALUES (3, 'Hal Barwood', 1992, 'Graphic Adventure', 'LucasArts');
INSERT INTO REVIEWS.REVIEW("ID", "REVIEW", "REVIEWER", "RATING", "GAMEID") VALUES (3, 'This game is better than previous one', 'Alex', 4, 3);

-- Doom
INSERT INTO GAMES.GAME("ID", "TITLE", "DESCRIPTIONHTML", "COVER", "SCREENSHOT") VALUES (4, 'Doom', '<p>In Doom, players assume the role of an unnamed space marine, who became popularly known as "Doomguy", fighting his way through hordes of invading demons from Hell.</p>', 'https://upload.wikimedia.org/wikipedia/en/5/57/Doom_cover_art.jpg', 'https://upload.wikimedia.org/wikipedia/en/d/de/Doom_ingame_1.png');
INSERT INTO DETAILS.DETAIL("ID", "DIRECTOR", "YEAR", "TYPE", "PUBLISHER") VALUES (4, 'John Romero et al', 1993, 'First-person shooter', 'id Software');
INSERT INTO REVIEWS.REVIEW("ID", "REVIEW", "REVIEWER", "RATING", "GAMEID") VALUES (4, 'Too much blood for my taste', 'Alex', 3, 4);

-- Day of the Tentacle
INSERT INTO GAMES.GAME("ID", "TITLE", "DESCRIPTIONHTML", "COVER", "SCREENSHOT") VALUES (5, 'Day of the Tentacle', '<p>The game''s plot follows Bernard Bernoulli and his friends Hoagie and Laverne as they attempt to stop the evil Purple Tentacle—a sentient, disembodied tentacle—from taking over the world. The player takes control of the trio and solves puzzles while using time travel to explore different periods of history.</p>', 'https://upload.wikimedia.org/wikipedia/en/7/79/Day_of_the_Tentacle_artwork.jpg', 'https://upload.wikimedia.org/wikipedia/en/b/b5/Day_of_the_Tentacle_Founding_Fathers.jpg');
INSERT INTO DETAILS.DETAIL("ID", "DIRECTOR", "YEAR", "TYPE", "PUBLISHER") VALUES (5, 'Tim Schafer et al', 1993, 'Graphic Adventure', 'LucasArts');
INSERT INTO REVIEWS.REVIEW("ID", "REVIEW", "REVIEWER", "RATING", "GAMEID") VALUES (5, 'The idea of three characters around different space of time is great', 'Alex', 5, 5);

-- Thimbleweed Park
INSERT INTO GAMES.GAME("ID", "TITLE", "DESCRIPTIONHTML", "COVER", "SCREENSHOT") VALUES (6, 'Thimbleweed Park', '<p>FBI agents Ray and Reyes arrive at the town of Thimbleweed Park to investigate a murder. Their investigation leads them to several persons of interest: Chuck, the recently deceased owner of the PillowTronics robotics company; Ransome the Clown, cursed to wear his makeup forever after going too far in his insulting performances; Delores, computer programmer and niece of Chuck; and Delores''s downtrodden father Franklin.</p>', 'https://upload.wikimedia.org/wikipedia/en/2/2b/Thimbleweed_Park.png', 'https://upload.wikimedia.org/wikipedia/en/9/9c/Thimbleweed_Park_screenshot.png');
INSERT INTO DETAILS.DETAIL("ID", "DIRECTOR", "YEAR", "TYPE", "PUBLISHER") VALUES (6, 'Ron Gilbert', 2017, 'Graphic Adventure', 'Terrible Toybox');
INSERT INTO REVIEWS.REVIEW("ID", "REVIEW", "REVIEWER", "RATING", "GAMEID") VALUES (6, 'Never played so I cannot rate', 'Alex', 0, 6);
