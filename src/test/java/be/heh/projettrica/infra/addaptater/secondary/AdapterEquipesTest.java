package be.heh.projettrica.infra.addaptater.secondary;

import be.heh.projettrica.domain.entities.Equipes;
import be.heh.projettrica.infra.addaptater.secondary.orm.EquipesRepository;
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
public class AdapterEquipesTest extends AbstractIntergrationTest{
    @Autowired
    private EquipesRepository equipesRepository;
    private EquipesMapper equipesMapper;

    private EquipesPersistenceAdapter equipesPersistenceAdapter;

    @Test
    @Sql({"createEquipesTable.sql","createEquipes.sql"})
    void getEquipesList(){
        equipesMapper = new EquipesMapper();
        equipesPersistenceAdapter = new EquipesPersistenceAdapter(equipesRepository,equipesMapper);

        List<Equipes> equipes;

        equipes = equipesPersistenceAdapter.getEquipesList();

        assertEquals("name1",equipes.get(0).getName());
        assertEquals("jeux2",equipes.get(1).getJeux());
        assertEquals(14,equipes.get(2).getNbplayer());
    }
}
