package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

    @GetMapping(value="/listar")

    public String listEnterprise() {
        return "Esto es una prueba";

    }

}
