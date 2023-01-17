package be.heh.projettrica.auth0;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the home page.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        // check if the principal object is not null
        if (principal != null) {
            // add the claims of the principal object to the model object with the key "profile"
            model.addAttribute("profile", principal.getClaims());
        }
        // return the string "Tournois", which is probably the name of the view (template) that will be used to render the response for this
        return "Tournois";
    }
}