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

    // Listar Empresas
    @GetMapping("/list")
    public String enterprises(Model model) {
        List<Enterprise> listaEmpresas = servicesEnterprise.enterprises();
        model.addAttribute("enterprises", listaEmpresas);
        return "/empresas/listarEmpresas";
    }

    // Crear Empresa
    @GetMapping
    public String createEnterprises(Model model) {
        model.addAttribute("enterprise", new Enterprise());
        return "/empresas/nuevaEmpresa";
    }

    // Guardar Empresa
    @PostMapping
    public String save(@ModelAttribute Enterprise enterprise) {
        servicesEnterprise.saveEnterprise(enterprise);
        return "redirect:/enterprises/list";
    }

    // Consultar Empresa por ID
    @GetMapping(value = "/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        Optional<Enterprise> enterprise = this.servicesEnterprise.getById(id);
        model.addAttribute("enterprise", enterprise.get());
        return "empresas/actualizarEmpresa";
    }

    // Actualizar Datos Empresa
    @PatchMapping(value = "/{id}")
    //@RequestMapping(value = "{id}", method = {RequestMethod.POST})
    public String updateEnterprise(@ModelAttribute Enterprise enterprise) {
        servicesEnterprise.saveEnterprise(enterprise);
        return "redirect:/enterprises/list";
    }

    // Eliminar Empresa
    @DeleteMapping(value = "/{id}")
    public String delete(@ModelAttribute Enterprise enterprise) {
        servicesEnterprise.delete(enterprise);
    return "redirect:/enterprises/list";
    }

}