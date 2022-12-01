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
    private final PortInTournois portInTournois;

    @Getter
    @Setter
    private List<Tournois> tournois = new ArrayList<>();

    @GetMapping("/")
    public String AfficheTournois(Model model){
        setTournois(getPortInTournois().AfficheTournois());
        model.addAttribute("tournois",getTournois());
        return "Tournois";
    }

    @PostMapping("/addTournoisForm")
    @ResponseBody
    public RedirectView addShoppingCart(@ModelAttribute("addAlbum") Tournois tournois) throws Exception{
        Tournois tournoisadd = new Tournois(tournois.getName(),tournois.getJeux(),tournois.getNbPart(),tournois.getVisible(),tournois.getDate());
        portInTournois.AddTournois(tournoisadd);
        return new RedirectView("/");

    }







}
