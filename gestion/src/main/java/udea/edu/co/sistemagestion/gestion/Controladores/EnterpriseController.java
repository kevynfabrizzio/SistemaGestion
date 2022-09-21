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
    @GetMapping("/{id}")
    public Optional<Enterprise> getById(@PathVariable long id) {
        return servicesEnterprise.getById(id);
    }

    // Pendiente Consulta Empresa
    /*@PostMapping(value = "/update/{id}")
    public String updateForm(@PathVariable("id") long id, Enterprise enterprise) {
        servicesEnterprise.saveEnterprise(enterprise);
        return "empresas/actualizarEmpresa";
    }*/
    // Pendiente Consulta Empresa
    @GetMapping(value = "/update/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("enterprise", servicesEnterprise.findById(id));
        return "empresas/actualizarEmpresa";
    }

    // ***** Pendiente Actualizar Guardar
    @PostMapping("/update/{id}")
    public String updateEnterprise(@ModelAttribute @Valid Enterprise enterprise, BindingResult bindingResult, Model model) {
        // refrescarModelo(model, principal);
        Optional<Enterprise> enterprise1 = servicesEnterprise.getById(enterprise.getId());
        // la busqueda de empleado puede o no traer un resultado;
        if (enterprise1.isPresent()) { // si el objeto es diferente de null
            enterprise = enterprise1.get();//Obtiene una Instancia PErmanente Objeto
            model.addAttribute("enterprise", enterprise);

        }// se obtiene la instancia
        return "empresas/listarEmpresas";
    }

    /*

@PostMapping(value = "/editar")
    public String actualizarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttrs) {
        productosRepository.save(producto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Editado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/productos/mostrar";
    }
*/
    // Eliminar OK
    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute Enterprise enterprise) {
        servicesEnterprise.delete(enterprise.getId());
        return "empresas/listarEmpresas";
    }

}