package be.heh.projettrica.domain.port.in;

import be.heh.projettrica.domain.entities.Tournois;

import java.util.List;

public interface PortInTournois {

    public List<Tournois> AfficheTournois();

    public void AddTournois(Tournois tournoisadd);

}
