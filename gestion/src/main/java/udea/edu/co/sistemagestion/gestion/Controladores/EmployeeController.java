package gestion.src.main.java.udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class EmployeeController {
    ArrayList employees=new ArrayList();
    Profile prof;
    @GetMapping
    public ArrayList employees() {
        return employees;
    }

    @PostMapping
    public ArrayList savex() {
        prof=new Profile();prof.setId("3");
        Employee emp=new Employee();emp.setId(employees.size());emp.setName("ramiro");emp.setProfile(prof);
        employees.add(emp);
        return employees;
    }

    @GetMapping("/user/{id}")//@GetMapping(value="/user/{id}") //para busquedas por un solo parametro
    public Employee findemployeeId(@PathVariable int id)
    {
        Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                break;
            }else{empx=null;}
        }
        return empx; //serviciosEmployee.buscarEmployee(id);
    }

    @PatchMapping("/user/{id}")
    public Employee upemployeeId(@PathVariable int id)
    {
        Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                empx.setName("ramon valdez");
                break;
            }else{empx=null;}
        }
        return empx; //serviciosEmployee.buscarEmployee(id);
    }

    @DeleteMapping("/user/{id}")
    public ArrayList delemployeeId(@PathVariable int id)
    {
        Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                employees.remove(empx);
                break;
            }
        }
        return employees; //serviciosEmployee.buscarEmployee(id);
    }
}