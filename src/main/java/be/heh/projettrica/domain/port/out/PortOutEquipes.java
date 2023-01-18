package be.heh.projettrica.domain.port.out;

import be.heh.projettrica.domain.entities.Equipes;

import java.util.List;

public interface PortOutEquipes {
    public List<Equipes> getEquipesList();

    void AddEquipes(Equipes Equipesadd);


}
