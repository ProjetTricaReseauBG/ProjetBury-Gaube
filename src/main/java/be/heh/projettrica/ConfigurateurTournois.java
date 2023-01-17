package be.heh.projettrica;

import be.heh.projettrica.domain.port.in.PortInEquipes;
import be.heh.projettrica.domain.port.out.PortOutEquipes;
import be.heh.projettrica.domain.usecase.EquipesUsecase;
import be.heh.projettrica.infra.addaptater.secondary.EquipesMapper;
import be.heh.projettrica.infra.addaptater.secondary.EquipesPersistenceAdapter;
import be.heh.projettrica.infra.addaptater.secondary.orm.EquipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class ConfigurateurTournois {
    @Autowired
    private EquipesRepository equipesRepository;
    private EquipesMapper equipesMapper = new EquipesMapper();
    private EquipesPersistenceAdapter equipesPersistenceAdapter;

    @Bean
    public PortInEquipes getPortInEquipes(){
        equipesPersistenceAdapter = new EquipesPersistenceAdapter(equipesRepository,equipesMapper);
        return new EquipesUsecase(equipesPersistenceAdapter);
    }

    @Bean
    public PortOutEquipes getPortOutEquipes(){
        return new EquipesPersistenceAdapter(equipesRepository,equipesMapper);
    }

}
