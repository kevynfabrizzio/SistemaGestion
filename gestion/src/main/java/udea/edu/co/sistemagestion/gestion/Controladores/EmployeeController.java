package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import udea.edu.co.sistemagestion.gestion.Entidades.*;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEmployee;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class EmployeeController {
    @Autowired
    ServicesEmployee servicesEmployee;

    @Autowired
    ServicesEnterprise servicesEnterprise;
    @GetMapping
    public String employees(Model model)//List<Employee> employees(Model model)
    {
        List<Employee> employees=servicesEmployee.employees();
        model.addAttribute("employees",employees);
        return "/usuarios/employees";
    }

    @GetMapping(value = "/nuevo2")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("profile", new Profile());
        model.addAttribute("enterprise", new Enterprise());
        return "usuarios/newEmployee2";
    }
    @PostMapping
    public String savex0000(@ModelAttribute Employee employee,Model model, @RequestParam("image") MultipartFile file) throws IOException, IOException {//guardar> implementacion pasando objeto;se accede localhost:8080/users/guardar y por postman le pasas el json
        System.out.println("ljhkjhljhjl");
        String rimg=this.servicesEmployee.savex2(employee,model,file);
        //model.addAttribute("profile",employee.getProfile());
        // this.servicesEmployee.savex3(employee.getProfile());
        return "redirect:/users/"; //servicesEmployee.savex2(employee);
    }
    @GetMapping("/{id}")
    public String editarx(@PathVariable int id,@ModelAttribute Employee employee,Model model){
        //long id=employee.getId();
        employee=servicesEmployee.findemployeeId(id).get();//.getId();
        model.addAttribute("employee",employee);
        model.addAttribute("profile",employee.getProfile());
        model.addAttribute("enterprise",employee.getEnterprise());
        return "usuarios/editar";
    }

    //@PatchMapping("/{id}")
    // public String actualizar(@PathVariable int id,@ModelAttribute Employee employee,Model model, @RequestParam("image") MultipartFile file) throws IOException {
    @PatchMapping
    public String actualizar(@ModelAttribute Employee employee,Model model, @RequestParam("image") MultipartFile file) throws IOException {
        if(file.isEmpty()){
            String rimg=this.servicesEmployee.savex23(employee,model);
        }else{
            String rimg=this.servicesEmployee.savex2(employee,model,file);
        }
        if(employee.getProfile().getImage().equals("")){}else{this.servicesEmployee.savex3(employee.getProfile());}
        //this.serviciosProfile.guardar(profile);
        return "redirect:/users/";
    }
    //@DeleteMapping("/{id}")//delete con un parametro;
    //public ArrayList delemployeeId(@PathVariable int id,@ModelAttribute Employee employee,Model model)
    @DeleteMapping
    public String delemployeeId(@ModelAttribute Employee employee,Model model)//, @RequestParam("image") MultipartFile file)
    {
        employee=servicesEmployee.findemployeeId(employee.getId()).get();//.getId();
        servicesEmployee.delemployeeObj(employee);
        return "redirect:/users/";
    }

}