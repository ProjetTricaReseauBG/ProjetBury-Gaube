package be.heh.projettrica;

import be.heh.projettrica.domain.port.in.PortInTournois;
import be.heh.projettrica.domain.port.out.PortOutTournois;
import be.heh.projettrica.domain.usecase.TournoisUsecase;
import be.heh.projettrica.infra.addaptater.secondary.TournoisMapper;
import be.heh.projettrica.infra.addaptater.secondary.TournoisPersistenceAdapter;
import be.heh.projettrica.infra.addaptater.secondary.orm.TournoisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
public class ConfigurateurTournois {
    @Autowired
    private TournoisRepository tournoisRepository;
    private TournoisMapper tournoisMapper = new TournoisMapper();
    private TournoisPersistenceAdapter tournoisPersistenceAdapter;

    @Bean
    public PortInTournois getPortInTournois(){
        tournoisPersistenceAdapter = new TournoisPersistenceAdapter(tournoisRepository,tournoisMapper);
        return new TournoisUsecase(tournoisPersistenceAdapter);
    }

    @Bean
    public PortOutTournois getPortOutTournois(){
        return new TournoisPersistenceAdapter(tournoisRepository,tournoisMapper);
    }

}
