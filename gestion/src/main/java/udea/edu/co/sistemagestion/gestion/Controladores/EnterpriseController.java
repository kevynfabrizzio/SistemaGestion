package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;

import javax.validation.Valid;
import java.util.Optional;
import java.util.List;

@Controller
@RequestMapping("/enterprises")
public class EnterpriseController {

    ServicesEnterprise servicesEnterprise;

    public EnterpriseController(ServicesEnterprise servicesEnterprise) {
        this.servicesEnterprise = servicesEnterprise;
    }

   /* public void refrescarModelo(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("enterprise", principal.getClaims());
            System.out.println("Info Empresa:" + principal.getClass());
        }
    }*/

    // Listar OK
    @GetMapping(value = "/list")
    public String enterprises(Model model) {
        List<Enterprise> listaEmpresas = servicesEnterprise.enterprises();
        model.addAttribute("enterprises", listaEmpresas);
        return "/empresas/listarEmpresas";//Ruta de destino en la vista
    }
    // Crear OK
    @GetMapping(value = "/create")
    public String createEnterprises(Model model) {
        model.addAttribute("enterprise", new Enterprise());
        return "/empresas/nuevaEmpresa";
    }
    // Guardar OK
    @PostMapping(value = "/save")
    public String save(@ModelAttribute Enterprise enterprise) {
        servicesEnterprise.saveEnterprise(enterprise);
        return "/empresas/listarEmpresas";
    }
    // Pendiente
    /*@GetMapping("/{id}")
    public Optional<Enterprise> getById(@PathVariable long id) {
        return servicesEnterprise.getById(id);
    }*/

    // Pendiente Consulta Empresa
    @GetMapping(value = "/update/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("enterprise", servicesEnterprise.findById(id));
        return "empresas/actualizarEmpresa";
    }

    // ***** Pendiente Actualizar Guardar
    @PostMapping(value = "/update")
    public String updateEnterprise(@ModelAttribute Enterprise enterprise) {
        servicesEnterprise.saveEnterprise(enterprise);
        return "empresas/listarEmpresas";
    }

    // Eliminar OK
    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute Enterprise enterprise) {
        servicesEnterprise.delete(enterprise.getId());
        return "empresas/listarEmpresas";
    }

}