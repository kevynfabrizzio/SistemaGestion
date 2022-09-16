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
        return "/empresas/listarEmpresas";//Ruta de destino en la vista
    }

    @GetMapping(value = "/create")
    public String createEnterprises(Model model){
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "/empresas/nuevaEmpresa";
    }

    @PostMapping(value = "/save")
    public String create(@ModelAttribute("form") Enterprise enterprise) {
        servicesEnterprise.saveEnterprise(enterprise);
        return "/empresas/listarEmpresas";
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