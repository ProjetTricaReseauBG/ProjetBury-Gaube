package be.heh.projettrica.domain.port.in;

import be.heh.projettrica.domain.entities.Equipes;

import java.util.List;

public interface PortInEquipes {

    public List<Equipes> AfficheEquipes();
    public void AddEquipes(Equipes Equipesadd);



}
