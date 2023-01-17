package be.heh.projettrica.infra.addaptater.secondary;


import be.heh.projettrica.domain.entities.Tournois;
import be.heh.projettrica.infra.addaptater.secondary.orm.TournoisJpaEntity;

import java.util.ArrayList;
import java.util.List;

// This class is a mapper that maps TournoisJpaEntity to Tournois and Tournois to TournoisJpaEntity
public class TournoisMapper {
    // This method maps a List of TournoisJpaEntity to a List of Tournois
    public List<Tournois> TournoisListMapJpaToDomain(List<TournoisJpaEntity> tournoisJpaEntities){
        List<Tournois> tournois = new ArrayList<>();
        // Iterate through the list of TournoisJpaEntity and create a new Tournois for each
        for (TournoisJpaEntity tournoisJpaEntity : tournoisJpaEntities){
            tournois.add(new Tournois(tournoisJpaEntity.getName(),tournoisJpaEntity.getJeux(),tournoisJpaEntity.getNbPart(),tournoisJpaEntity.getVisible(),tournoisJpaEntity.getNumerot()));
        }
        return tournois;
    }
    // This method maps a Tournois to a TournoisJpaEntity
    public TournoisJpaEntity TournoisMapDomainToJpa(Tournois tournois){
        return new TournoisJpaEntity(tournois.getName(),tournois.getJeux(),tournois.getNbPart(),tournois.getVisible(),tournois.getNumerot());
    }


}
