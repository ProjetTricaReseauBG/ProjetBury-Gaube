CREATE TABLE IF NOT EXISTS tournois(
    nametournois varchar(256),
    jeux varchar(256),
    nbpart int,
    numerot SERIAL primary key,
    visible int
    );
SET timezone = 'Europe/Brussels';