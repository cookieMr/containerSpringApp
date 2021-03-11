GRANT ALL PRIVILEGES ON DATABASE mcu TO docker;

CREATE TABLE IF NOT EXISTS MOVIES (
    ID SERIAL PRIMARY KEY,
    TITLE VARCHAR(50) NOT NULL,
    RELEASE_YEAR NUMERIC NOT NULL
);

INSERT INTO movies (title, release_year) values
    ('Iron Man', 2008),
    ('The Incredible Hulk', 2008),
    ('Iron Man 2', 2010),
    ('Thor', 2011),
    ('Captain America: The First Avenger', 2011),
    ('Marvel''s The Avengers', 2012),
    ('Iron Man 3', 2013),
    ('Thor: The Dark World', 2013),
    ('Captain America: The Winter Soldier', 2014),
    ('Guardians of the Galaxy', 2014),
    ('Avengers: Age of Ultron', 2015),
    ('Ant-Man', 2015),
    ('Captain America: Civil War', 2016),
    ('Doctor Strange', 2016),
    ('Guardians of the Galaxy Vol. 2', 2017),
    ('Spider-Man: Homecoming', 2017),
    ('Thor: Ragnarok', 2017),
    ('Black Panther', 2018),
    ('Avengers: Infinity War', 2018),
    ('Ant-Man and the Wasp', 2018),
    ('Captain Marvel', 2019),
    ('Avengers: Endgame', 2019),
    ('Spider-Man: Far From Home', 2019);
