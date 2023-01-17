package be.heh.projettrica.domain.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Tournois {

    @Getter
    private final String name; // name of the tournament

    @Getter
    private final String jeux; // name of the game

    @Getter
    private final int nbPart; // number of participants

    @Getter
    private final int visible; // visibility of the tournament

    @Getter
    private final long numerot; // tournament number
}
