package be.heh.projettrica.infra.addaptater.secondary;


import be.heh.projettrica.domain.entities.Tournois;
import be.heh.projettrica.infra.addaptater.secondary.orm.TournoisJpaEntity;

import java.util.ArrayList;
import java.util.List;

public class TournoisMapper {
    public List<Tournois> TournoisListMapJpaToDomain(List<TournoisJpaEntity> tournoisJpaEntities){
        List<Tournois> tournois = new ArrayList<>();

        for (TournoisJpaEntity tournoisJpaEntity : tournoisJpaEntities){
            tournois.add(new Tournois(tournoisJpaEntity.getName(),tournoisJpaEntity.getJeux(),tournoisJpaEntity.getNbPart(),tournoisJpaEntity.getVisible(),tournoisJpaEntity.getNumerot()));
        }
        return tournois;
    }

    public TournoisJpaEntity TournoisMapDomainToJpa(Tournois tournois){
        return new TournoisJpaEntity(tournois.getName(),tournois.getJeux(),tournois.getNbPart(),tournois.getVisible(),tournois.getNumerot());
    }


}
