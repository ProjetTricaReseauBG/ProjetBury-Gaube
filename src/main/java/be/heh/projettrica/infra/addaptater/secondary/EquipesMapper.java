package be.heh.projettrica.infra.addaptater.secondary;


import be.heh.projettrica.domain.entities.Equipes;
import be.heh.projettrica.infra.addaptater.secondary.orm.EquipesJpaEntity;

import java.util.ArrayList;
import java.util.List;

public class EquipesMapper {
    public List<Equipes> EquipesListMapJpaToDomain(List<EquipesJpaEntity> equipesJpaEntities){
        List<Equipes> equipes = new ArrayList<>();

        for (EquipesJpaEntity equipesJpaEntity : equipesJpaEntities){
            equipes.add(new Equipes(equipesJpaEntity.getName(),equipesJpaEntity.getJeux(),equipesJpaEntity.getNbplayer(),equipesJpaEntity.getVisible(),equipesJpaEntity.getNbwin(), equipesJpaEntity.getIdequipe()));
        }
        return equipes;
    }

    public EquipesJpaEntity EquipesMapDomainToJpa(Equipes equipes){
        return new EquipesJpaEntity(equipes.getName(),equipes.getJeux(),equipes.getNbplayer(),equipes.getVisible(),equipes.getNbwin(), equipes.getIdequipe());
    }
}
