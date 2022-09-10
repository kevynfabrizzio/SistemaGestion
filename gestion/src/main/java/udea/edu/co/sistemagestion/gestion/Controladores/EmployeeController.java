package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.*;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEmployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class EmployeeController {

    @Autowired
    ServicesEmployee servicesEmployee;
    public EmployeeController(ServicesEmployee servicesEmployee){
        this.servicesEmployee=servicesEmployee;
    }
    ArrayList employees;
    Profile prof;
    @GetMapping
    public List<Employee> employees() {//este metodo se accede con localhost:8080/users, y retorna la coleccion
        return servicesEmployee.employees();// employees;
    }

    @PostMapping
    public ArrayList savex() {//metodo savex> implemetacion basica: se accede localhost:8080/users
        return servicesEmployee.savex();// employees;// retorna arraylist
    }

    @PostMapping(value="/guardar")
    public ArrayList savex1(@RequestBody Employee employee)//guardar> implementacion pasando objeto;se accede localhost:8080/users/guardar y por postman le pasas el json
    {
        return servicesEmployee.savex1(employee);
    }

    @GetMapping("/user/{id}")//@GetMapping(value="/user/{id}") //para busquedas por un solo parametro; le quite el value
    public Employee findemployeeId(@PathVariable int id)// Este metodo pasa parametro primitivo y lo busca en la a la coleecion q se llena con los @PostMapping
    {
        return servicesEmployee.findemployeeId(id);
    }
    @GetMapping("/userx")//@GetMapping(value="/user/{id}") //para busquedas por un solo parametro; le quite el value
    public Employee findemployeeIdx(@RequestParam int id)// Este metodo pasa parametro primitivo y lo busca en la a la coleecion q se llena con los @PostMapping
    {
        return servicesEmployee.findemployeeIdx(id);
    }
    @PatchMapping("/user/{id}")//update con un parametro
    public Employee upemployeeId(@PathVariable int id)
    {
        return servicesEmployee.upemployeeId(id);
    }
    @PatchMapping("/user/{id}/{name}")//update con 2(multiples parametros)
    public Employee upemployeeIdName(@PathVariable int id, @PathVariable String name)
    {
        return  servicesEmployee.upemployeeIdName(id,name);
    }
    @PatchMapping("/user/update")//update con 2(multiples parametros)
    public ArrayList upemployee(@RequestBody Employee employee)
    {
        return  servicesEmployee.upemployee(employee);
    }

    @DeleteMapping("/user/{id}")//delete con un parametro
    public ArrayList delemployeeId(@PathVariable int id)
    {
        return servicesEmployee.delemployeeId(id);
    }
}