package be.heh.projettrica.domain.port.in;

import be.heh.projettrica.domain.entities.Tournois;

import java.util.List;

public interface PortInTournois {

    public List<Tournois> AfficheTournois(); // method to get a list of Tournois

    public void AddTournois(Tournois tournoisadd); // method to add a Tournois

}
