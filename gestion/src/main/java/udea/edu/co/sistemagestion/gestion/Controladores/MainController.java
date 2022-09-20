package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;


@Controller
public class MainController {
    ServicesEnterprise servicesEnterprise;

    public MainController(ServicesEnterprise servicesEnterprise)
    {
        this.servicesEnterprise = servicesEnterprise;
    }

  @GetMapping("/")
    public String index() {
        return "index";
    }

   /* @GetMapping(value = "/ingresosEgresos")
    public String ingEgr(){
        return "ingresosEgresos/ingresosEgresos";
    }

   @GetMapping(value = "/enterprises")//Entidad asociada
   public String emp(){
       return "empresas/listarEmpresas";// Rita de destino en la vista
    }

    @GetMapping(value = "/enterprises/nueva")//Entidad asociada
    public String nEmp(){
        return "empresas/nuevaEmpresa";// Rita de destino en la vista
    }*/


}
