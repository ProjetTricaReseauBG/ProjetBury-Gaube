package be.heh.projettrica.domain.usecase;

import be.heh.projettrica.domain.entities.Equipes;
import be.heh.projettrica.domain.port.in.PortInEquipes;
import be.heh.projettrica.domain.port.out.PortOutEquipes;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EquipesUsecase implements PortInEquipes {

    private final PortOutEquipes portoutEquipes;
    @Override
    public List<Equipes> AfficheEquipes() {
        return portoutEquipes.getEquipesList();
    }

    public void AddEquipes(Equipes Equipesadd) {
        portoutEquipes.AddEquipes(Equipesadd);
    }
}
