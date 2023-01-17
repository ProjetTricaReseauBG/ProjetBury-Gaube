package be.heh.projettrica.infra.addaptater.secondary.primary;

import be.heh.projettrica.domain.entities.Equipes;
import be.heh.projettrica.domain.port.in.PortInEquipes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ControlerEquipes {
    @Getter
    private final PortInEquipes portInEquipes;

    @Getter
    @Setter
    private List<Equipes> equipes = new ArrayList<>();

    @GetMapping("/")
    public String AfficheEquipes(Model model){
        setEquipes(getPortInEquipes().AfficheEquipes());
        model.addAttribute("equipes",getEquipes());
        return "Equipes";
    }
}
