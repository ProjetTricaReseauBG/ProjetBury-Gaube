package be.heh.projettrica.infra.addaptater.primary;

import be.heh.projettrica.domain.entities.Equipes;
import be.heh.projettrica.domain.port.in.PortInEquipes;
import be.heh.projettrica.infra.addaptater.secondary.primary.ControlerEquipes;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(ControlerEquipes.class)
public class ControlerEquipesTest {

    private SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PortInEquipes portInEquipes;

    private List<Equipes> equipes = new ArrayList<>();

    @Test
    public void AfficheEquipes() throws Exception{
        equipes.add(new Equipes("nom1","jeux1",12,23432, 12, 24));
        equipes.add(new Equipes("nom2","jeux2",13,48578,1, 14));
        equipes.add(new Equipes("nom3","jeux3",14,49504,13, 42));

        //stub

        Mockito.when(portInEquipes.AfficheEquipes()).thenReturn(equipes);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("Equipes"))
                .andExpect(model().attributeExists("equipes"))
                .andExpect(model().attribute("equipes", Matchers.hasSize(3)));
    }
}
