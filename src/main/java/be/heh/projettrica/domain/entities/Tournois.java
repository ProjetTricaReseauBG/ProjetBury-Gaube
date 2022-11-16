package be.heh.projettrica.domain.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class Tournois {

    @Getter
    private final String name;

    @Getter
    private final String jeux;

    @Getter
    private final int nbPart;

    @Getter
    private final int visible;

    @Getter
    private final Date date;
}
