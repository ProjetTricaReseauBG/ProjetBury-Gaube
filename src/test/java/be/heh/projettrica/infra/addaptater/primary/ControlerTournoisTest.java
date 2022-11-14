package be.heh.projettrica.infra.addaptater.primary;

import be.heh.projettrica.domain.entities.Tournois;
import be.heh.projettrica.domain.port.in.PortInTournois;
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
import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(ControlerTournois.class)
public class ControlerTournoisTest {

    private SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PortInTournois portInTournois;

    private List<Tournois> tournois = new ArrayList<>();

    @Test
    public void AfficheTournois() throws Exception{
        tournois.add(new Tournois("nom1","jeux1",12,23432,1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-07-10 14:58:00")));
        tournois.add(new Tournois("nom2","jeux2",13,48578,1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-07-10 14:58:00")));
        tournois.add(new Tournois("nom3","jeux3",14,49504,1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-07-10 14:58:00")));

        //stub

        Mockito.when(portInTournois.AfficheTournois()).thenReturn(tournois);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("Tournois"))
                .andExpect(model().attributeExists("tournois"))
                .andExpect(model().attribute("tournois", Matchers.hasSize(3)));
    }
}
