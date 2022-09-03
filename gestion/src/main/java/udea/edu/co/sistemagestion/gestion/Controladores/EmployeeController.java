package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udea.edu.co.sistemagestion.gestion.Entidades.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    ArrayList employees=new ArrayList();
    Profile prof;
    @GetMapping(value = "/users")
    public ArrayList employees() {
        return employees;
    }

    @PostMapping(value = "/users")
    public ArrayList savex() {
        prof=new Profile();prof.setId("3");
        Employee emp=new Employee();emp.setId(employees.size());emp.setName("ramiro");emp.setProfile(prof);
        employees.add(emp);
        return employees;
    }
}
