package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEmployee;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    ServicesEnterprise servicesEnterprise;
    @Autowired
    ServicesEmployee servicesEmployee;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "index";
    }

}
