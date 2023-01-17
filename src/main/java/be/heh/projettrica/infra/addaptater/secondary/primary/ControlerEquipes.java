package be.heh.projettrica.infra.addaptater.secondary.primary;

import be.heh.projettrica.domain.entities.Equipes;
import be.heh.projettrica.domain.port.in.PortInEquipes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

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


    @GetMapping("/addEquipes")
    public String AddEquipes(){
        return "/AddEquipes";
    }


    @PostMapping("/addEquipesForm")
    @ResponseBody
    public RedirectView AddEquipes(@ModelAttribute("equipesadd") Equipes equipes) throws Exception{
        Equipes equipesadd = new Equipes(equipes.getName(),equipes.getJeux(),equipes.getNbplayer(),equipes.getVisible(),equipes.getNbwin(),equipes.getIdequipe());
        portInEquipes.AddEquipes(equipesadd);
        return new RedirectView("/addEquipes");

    }

}
