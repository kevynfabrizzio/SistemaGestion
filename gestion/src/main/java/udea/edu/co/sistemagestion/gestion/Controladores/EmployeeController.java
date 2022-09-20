package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.*;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEmployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class EmployeeController {
    @Autowired
    ServicesEmployee servicesEmployee;
   /* public EmployeeController(ServicesEmployee servicesEmployee){
        this.servicesEmployee=servicesEmployee;
    }*/

    // 1. El sistema devuelve reponses 200 en la ruta /users con GET
   /* @GetMapping
    public List<Employee> employees()
    {
        //este metodo se accede con localhost:8080/users, y retorna la coleccion
        return servicesEmployee.employees();// employees;
    }*/
    @GetMapping
    public String employees(Model model)//List<Employee> employees(Model model)
    {
        //este metodo se accede con localhost:8080/users, y retorna la coleccion
        List<Employee> employees=servicesEmployee.employees();
        // Estableciendo en el modelo la lista de empleados, para que el HTML La pueda visualizar
        model.addAttribute("employees",employees);
        //return servicesEmployee.employees();// employees;
        return "/usuarios/employees";
    }

    // 2. El sistema devuelve reponses 200 en la ruta /users con POST
    // aqui hay 2 formas con post pare este definition of done
    // la primera guarda un objeto Employee pasando por url id_profile y name de employee asi: localhost.../users?id=1&name=pedro
    //la segunda lo mismo pero el url es: localhost../users/1/pedro
    //y la tercera pasa un JSON asi: localhost.../users/save; y por postman le pasas el json Emplloyee
    @PostMapping
    public ArrayList savex2(@RequestParam("idProf") String idProf,@RequestParam("name") String name) {

        // metodo savex> implemetacion basica: se accede localhost:8080/users
        return servicesEmployee.savex2(idProf,name);// employees;// retorna arraylist
    }
    @PostMapping("/{idprof}/{name}")
    public ArrayList savex4(@PathVariable String idprof,@PathVariable String name) {

        // metodo savex> implemetacion basica: se accede localhost:8080/users
        return servicesEmployee.savex2(idprof,name);// employees;// retorna arraylist
    }
    @PostMapping("/save")
    public ArrayList savex5(@RequestBody Employee employee) {

        // metodo savex> implemetacion basica: se accede localhost:8080/users
        return servicesEmployee.savex1(employee);// employees;// retorna arraylist
    }
    @GetMapping("/nuevo")
    public String employeenew(){
        return "usuarios/newEmployee";
    }
    @PostMapping("/guardarx")
    public String guardarx(@RequestParam("name") String name, @RequestParam("email")  String email,@RequestParam("role")  String role, @RequestParam("phone") String phone)
    {
        servicesEmployee.guardarx(name,email,role,phone);

        // guardar objeto Employee
        //servicesEmployee.savex1(employee);
        //return "redirect:/Employee/listar";
        return "redirect:/users/";// con esta linea ya retorna lo q guarda
    }

    // 3. El sistema devuelve reponses 200 en la ruta /users/[id] con GET
    @GetMapping("/{id}")
    public Employee findemployeeId(@PathVariable int id)// Este metodo pasa parametro primitivo y lo busca en la a la coleecion q se llena con los @PostMapping
    {
        return servicesEmployee.findemployeeId(id);
    }

    // 4. El sistema devuelve reponses 200 en la ruta /users/[id] con PATCH
    @PatchMapping("/{id}")//update con un parametro;
    public Employee upemployeeId(@PathVariable int id)
    {
        return servicesEmployee.upemployeeId(id);
    }

    // 5. El sistema devuelve reponses 200 en la ruta /users/[id] con GET
    @DeleteMapping("/{id}")//delete con un parametro;
    public ArrayList delemployeeId(@PathVariable int id)
    {
        return servicesEmployee.delemployeeId(id);
    }

    //Otras formas con get post patch delete
    @PostMapping("/byname_prof")
    public ArrayList savex1x(@RequestParam("name") String name,@RequestParam("idprofile") String id) {//metodo savex1> implemetacion basica: se accede localhost:8080/users
        return servicesEmployee.savex1x(name,id);// employees;// retorna arraylist
    }

    @PostMapping(value="/guardar")
    public ArrayList savex3(@RequestBody Employee employee)//guardar> implementacion pasando objeto;se accede localhost:8080/users/guardar y por postman le pasas el json
    {
        return servicesEmployee.savex1(employee);
    }


    @GetMapping("/userx")//@GetMapping(value="/user/{id}") //para busquedas por un solo parametro; le quite el value
    public Employee findemployeeIdx(@RequestParam int id)// Este metodo pasa parametro primitivo y lo busca en la a la coleecion q se llena con los @PostMapping
    {
        return servicesEmployee.findemployeeId(id);
    }


    @PatchMapping("/user/{id}/{name}")//update con 2(multiples parametros)
    public Employee upemployeeIdName(@PathVariable int id, @PathVariable String name)
    {
        return  servicesEmployee.upemployeeIdName(id,name);
    }
    @PatchMapping("/user/update")//update pasando object
    public ArrayList upemployee(@RequestBody Employee employee)
    {
        return  servicesEmployee.upemployee(employee);
    }
/*
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
    @GetMapping("/userx") //@GetMapping(value="/user/{id}") //para busquedas por un solo parametro; le quite el value
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
    }*/
}