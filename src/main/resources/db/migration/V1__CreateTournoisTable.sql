CREATE TABLE IF NOT EXISTS tournois(
    nametournois varchar(256),
    jeux varchar(256),
    nbpart int,
    numerot SERIAL primary key,
    visible int,
    datet timestamp
    );
SET timezone = 'Europe/Brussels';