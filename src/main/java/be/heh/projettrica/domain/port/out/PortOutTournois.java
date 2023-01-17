package be.heh.projettrica.domain.port.out;

import be.heh.projettrica.domain.entities.Tournois;

import java.util.List;

public interface PortOutTournois {
    public List<Tournois> getTournoisList(); // method to get a list of Tournois

    void AddTournois(Tournois tournoisadd); // method to add a Tournois
}
