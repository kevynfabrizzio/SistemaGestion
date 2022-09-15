package udea.edu.co.sistemagestion.gestion.Controladores;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;
import java.util.Optional;
import java.util.List;

@Controller
@RequestMapping("/enterprises")
public class EnterpriseController{

    ServicesEnterprise servicesEnterprise;

    public EnterpriseController(ServicesEnterprise servicesEnterprise) {
        this.servicesEnterprise = servicesEnterprise;
    }

    @GetMapping(value = "/list")
    public String enterprises(Model model){
        List<Enterprise> listaEmpresas = servicesEnterprise.enterprises();
        model.addAttribute("enterprises", listaEmpresas);
        return "/empresas/listarEmpresas";
    }

    @PostMapping
    public Enterprise saveEnterprise(Enterprise enterprise) {
        return servicesEnterprise.saveEnterprise(enterprise);
    }

    @GetMapping("/{id}")
    public Optional<Enterprise> getById(@PathVariable long id){
        return servicesEnterprise.getById(id);
    }

    @PatchMapping("/{id}")
    public Enterprise updateEnterprise(@PathVariable long id){
        return servicesEnterprise.updateEnterprise(id,null);
    }

    @DeleteMapping("/{id}")
    public void delete (Enterprise enterprise){
        servicesEnterprise.delete(enterprise);
    }

}