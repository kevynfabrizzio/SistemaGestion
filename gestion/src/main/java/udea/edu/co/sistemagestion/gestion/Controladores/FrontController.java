package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;

import java.util.List;


@Controller
public class FrontController {

    ServicesEnterprise servicesEnterprise;

    public FrontController(ServicesEnterprise servicesEnterprise)
    {
        this.servicesEnterprise = servicesEnterprise;
    }

  @GetMapping("/")
    public String index() {
        return "index";
    }

    /*@GetMapping("/enterprises")
    public String empresas (Model model){
        List<Enterprise> empresas = this.servicesEnterprise.enterprises();
        model.addAttribute("enterprises", empresas);
        return "/enterprises";
    }*/

}
