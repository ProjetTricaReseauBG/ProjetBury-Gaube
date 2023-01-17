CREATE TABLE IF NOT EXISTS equipes(
    nameequipes varchar(256),
    jeux varchar(256),
    nbplayer int,
    numerot SERIAL primary key,
    visible int,
    nbwin int,
    idequipe int
    );
SET timezone = 'Europe/Brussels';