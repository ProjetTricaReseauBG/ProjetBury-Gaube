CREATE TABLE IF NOT EXISTS equipes(
    nameequipes varchar(256),
    jeux varchar(256),
    nbplayer int,
    visible int,
    nbwin int,
    idequipe SERIAL primary key
    );
SET timezone = 'Europe/Brussels';