package udea.edu.co.sistemagestion.gestion.Controladores;


import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;
import java.util.Optional;
import java.util.List;


@RestController
@RequestMapping("/enterprises")
public class EnterpriseController{

    ServicesEnterprise servicesEnterprise;

    public EnterpriseController(ServicesEnterprise servicesEnterprise) {
        this.servicesEnterprise = servicesEnterprise;
    }

    //
    @GetMapping()
    public List<Enterprise> enterprises() {
        return servicesEnterprise.enterprises();
    }

    //
    @PostMapping()
    public Enterprise create(@RequestBody Enterprise enterprise){
        return servicesEnterprise.saveEnterprise(enterprise);
    }

    @GetMapping(value = "/enterprise/{id}")
    public Optional<Enterprise> findBy (@PathVariable long id){
        return servicesEnterprise.findEnterprise(id);
    }

    @PatchMapping(value = "/enterprise/{id}")
    public Enterprise update(@RequestBody long id, @RequestBody Enterprise enterprise){
        return servicesEnterprise.updateEnterprise(id,enterprise);
    }

    @DeleteMapping(value = "/enterprise/{id}")
    public String delete(@PathVariable Enterprise enterprise){
        servicesEnterprise.deleteEnterprise(enterprise);
        return "redirect:/enterprise";
    }

}