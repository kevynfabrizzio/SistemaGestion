package udea.edu.co.sistemagestion.gestion.Controladores;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEmployee;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;
import java.util.Optional;
import java.util.List;

@Controller
@RequestMapping("/enterprises")
public class EnterpriseController{

    ServicesEnterprise servicesEnterprise;
    ServicesEmployee servicesEmployee;

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
        model.addAllAttributes();
        return "/empresas/nuevaEmpresa";
    }

    @PostMapping(value = "/save")
    public String create(@RequestParam("name") String name, @RequestParam("document")  String document, @RequestParam("phone")  String phone, @RequestParam("address") String address) {
        servicesEnterprise.saveEnterprise(name, document, phone, address, this.servicesEmployee);
        return "redirect:/empresas/listarEmpresas";
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