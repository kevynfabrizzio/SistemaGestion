package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEmployee;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    ServicesEnterprise servicesEnterprise;
    @Autowired
    ServicesEmployee servicesEmployee;
  /*  public MainController(ServicesEnterprise servicesEnterprise)
    {
        this.servicesEnterprise = servicesEnterprise;
    }*/

  @GetMapping("/")
    public String index() {
        return "index";
    }
  /*@GetMapping(value="/employees/")
    public String employees(){
        return "usuarios/employees" ;
    }*/

 /*   @GetMapping("/employees/")
    public String employees(Model model)//List<Employee> employees(Model model)
    {
        //este metodo se accede con localhost:8080/users, y retorna la coleccion
        List<Employee> employees=servicesEmployee.employees();
        // Estableciendo en el modelo la lista de empleados, para que el HTML La pueda visualizar
        model.addAttribute("employees",employees);
        //return servicesEmployee.employees();// employees;
        return "/usuarios/employees";
    }
    @GetMapping("/newEmployeex/")
    public String newEmployee() {
        return "users/nuevo";
    }
    @GetMapping(value = "/ingresosEgresos")
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
