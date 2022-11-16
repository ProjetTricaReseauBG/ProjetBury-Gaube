package be.heh.projettrica.infra.addaptater.secondary;

import be.heh.projettrica.domain.entities.Tournois;
import be.heh.projettrica.domain.port.out.PortOutTournois;
import be.heh.projettrica.infra.addaptater.secondary.orm.TournoisJpaEntity;
import be.heh.projettrica.infra.addaptater.secondary.orm.TournoisRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class TournoisPersistenceAdapter implements PortOutTournois {
    private final TournoisRepository tournoisRepository;
    private final TournoisMapper tournoisMapper;
    @Override
    public List<Tournois> getTournoisList() {
        List<TournoisJpaEntity> tournoisJpaEntities = tournoisRepository.findAll();
        return tournoisMapper.TournoisListMapJpaToDomain(tournoisJpaEntities);
    }
}
