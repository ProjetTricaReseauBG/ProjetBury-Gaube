package be.heh.projettrica.domain.port.out;

import be.heh.projettrica.domain.entities.Tournois;

import java.util.List;

public interface PortOutTournois {
    public List<Tournois> getTournoisList();
}
