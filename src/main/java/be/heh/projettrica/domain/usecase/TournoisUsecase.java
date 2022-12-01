package be.heh.projettrica.domain.usecase;

import be.heh.projettrica.domain.entities.Tournois;
import be.heh.projettrica.domain.port.in.PortInTournois;
import be.heh.projettrica.domain.port.out.PortOutTournois;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TournoisUsecase implements PortInTournois {

    private final PortOutTournois portouttournois;
    @Override
    public List<Tournois> AfficheTournois() {
        return portouttournois.getTournoisList();
    }

    @Override
    public void AddTournois(Tournois tournoisadd) {
        portouttournois.AddTournois(tournoisadd);
    }
}
