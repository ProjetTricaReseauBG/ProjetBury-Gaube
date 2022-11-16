package be.heh.projettrica.infra.addaptater.secondary;

import be.heh.projettrica.domain.entities.Tournois;
import be.heh.projettrica.infra.addaptater.secondary.orm.TournoisRepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdapterTournoisTest extends AbstractIntergrationTest{
    @Autowired
    private TournoisRepository tournoisRepository;
    private TournoisMapper tournoisMapper;

    private TournoisPersistenceAdapter tournoisPersistenceAdapter;

    @Test
    @Sql({"createTournoisTable.sql","createTournois.sql"})
    void getTournoisList(){
        tournoisMapper = new TournoisMapper();
        tournoisPersistenceAdapter = new TournoisPersistenceAdapter(tournoisRepository,tournoisMapper);

        List<Tournois> tournois;

        tournois = tournoisPersistenceAdapter.getTournoisList();

        assertEquals("name1",tournois.get(0).getName());
        assertEquals("jeux2",tournois.get(1).getJeux());
        assertEquals(14,tournois.get(2).getNbPart());
    }
}
