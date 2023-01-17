package be.heh.projettrica.infra.addaptater.secondary;

import be.heh.projettrica.domain.entities.Tournois;
import be.heh.projettrica.domain.port.out.PortOutTournois;
import be.heh.projettrica.infra.addaptater.secondary.orm.TournoisJpaEntity;
import be.heh.projettrica.infra.addaptater.secondary.orm.TournoisRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor // Lombok annotation for constructor injection
public class TournoisPersistenceAdapter implements PortOutTournois {
    private final TournoisRepository tournoisRepository; // Autowired repository
    private final TournoisMapper tournoisMapper; // Autowired mapper

    // Implementing the PortOutTournois interface
    @Override
    public List<Tournois> getTournoisList() {
        // Retrieve all TournoisJpaEntity from the repository
        List<TournoisJpaEntity> tournoisJpaEntities = tournoisRepository.findAll();
        // Use the mapper to convert the list of TournoisJpaEntity to a list of Tournois
        return tournoisMapper.TournoisListMapJpaToDomain(tournoisJpaEntities);
    }

    @Override
    public void AddTournois(Tournois tournoisadd) {
        // Use the mapper to convert the Tournois to a TournoisJpaEntity
        tournoisRepository.save(tournoisMapper.TournoisMapDomainToJpa(tournoisadd));
        // Save the TournoisJpaEntity to the repository
    }
}
