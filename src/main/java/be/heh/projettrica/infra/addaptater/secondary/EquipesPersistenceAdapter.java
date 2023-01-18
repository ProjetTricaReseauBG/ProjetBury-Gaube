package be.heh.projettrica.infra.addaptater.secondary;

import be.heh.projettrica.domain.entities.Equipes;
import be.heh.projettrica.domain.port.out.PortOutEquipes;
import be.heh.projettrica.infra.addaptater.secondary.orm.EquipesJpaEntity;
import be.heh.projettrica.infra.addaptater.secondary.orm.EquipesRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class EquipesPersistenceAdapter implements PortOutEquipes {
    private final EquipesRepository equipesRepository;
    private final EquipesMapper equipesMapper;
    @Override
    public List<Equipes> getEquipesList() {
        List<EquipesJpaEntity> equipesJpaEntities = equipesRepository.findAll();
        return equipesMapper.EquipesListMapJpaToDomain(equipesJpaEntities);
    }

    @Override
    public void AddEquipes(Equipes equipesadd) {
        equipesRepository.save(equipesMapper.EquipesMapDomainToJpa(equipesadd));
    }
}
