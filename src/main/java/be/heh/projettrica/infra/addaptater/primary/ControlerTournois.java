package be.heh.projettrica.infra.addaptater.primary;

import be.heh.projettrica.domain.entities.Tournois;
import be.heh.projettrica.domain.port.in.PortInTournois;
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
public class ControlerTournois {

    @Getter
    private final PortInTournois portInTournois; // instance variable of PortInTournois interface

    @Getter
    @Setter
    private List<Tournois> tournois = new ArrayList<>(); // a list of Tournois

    @GetMapping("/viewTournois")
    public String AfficheTournois(Model model){
        setTournois(getPortInTournois().AfficheTournois()); // use the portInTournois to get the list of Tournois
        model.addAttribute("tournois",getTournois()); // add the list of Tournois to the model
        return "viewTournois";
    }
    @GetMapping("/addTournois")
    public String AddTournois(){
        return "/AddTournois";
    }


    @PostMapping("/addTournoisForm")
    @ResponseBody
    public RedirectView AddTournois(@ModelAttribute("tournoisadd") Tournois tournois) throws Exception{
        Tournois tournoisadd = new Tournois(tournois.getName(),tournois.getJeux(),tournois.getNbPart(),tournois.getVisible(),tournois.getNumerot());
        portInTournois.AddTournois(tournoisadd); // use the portInTournois to add a Tournois
        return new RedirectView("/");

    }









}
