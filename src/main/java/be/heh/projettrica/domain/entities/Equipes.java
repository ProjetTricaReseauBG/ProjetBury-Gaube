package be.heh.projettrica.domain.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Equipes {

    @Getter
    private final String name;

    @Getter
    private final String jeux;

    @Getter
    private final int nbplayer;

    @Getter
    private final int visible;

    @Getter
    private final int nbwin;

    @Getter
    private final long idequipe;
}
