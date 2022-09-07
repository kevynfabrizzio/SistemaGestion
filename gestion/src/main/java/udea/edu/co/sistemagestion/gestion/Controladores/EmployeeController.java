package udea.edu.co.sistemagestion.gestion.Controladores;

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
        //esta ruta cada vez q hagas un post, creara un profile y un epmployee, el profile se setea en employee
        //y se guarda en la coleccion para luego mostrarla.
        //Entonces se crea un profile y se setea el ID(linea 25) para ejemplo(faltan los otros set); se podria haber utilizado el constuctor con parametros
        //   prof=new Profile();prof.setId("3");
        //se crea employee(linea 26); se setea con id automatico; se añade el profile anterior;
        //  Employee emp=new Employee();emp.setId(employees.size());emp.setName("ramiro");emp.setProfile(prof);
        // if(employees==null || employees.size()==0){employees=new ArrayList();}//se asegura q solo exista una instancia de la coleccion
        // employees.add(emp);//se guarda
        return servicesEmployee.savex();// employees;// retorna arraylist
    }

    @PostMapping(value="/guardar")
    public ArrayList savex1(@RequestBody Employee employee)//guardar> implementacion pasando objeto;se accede localhost:8080/users/guardar y por postman le pasas el json
    {
        //return new ResponseEntity<Employee>(empleado, HttpStatus.OK); // el profe retornaba con ResponseEntity
        //   if(employees==null || employees.size()==0){employees=new ArrayList();}//instancio coleccion si es null, para poder llenarla
        // employees.add(empleado);return employees;//guardo y retorno..
        return servicesEmployee.savex1(employee);
    }

    @GetMapping("/user/{id}")//@GetMapping(value="/user/{id}") //para busquedas por un solo parametro; le quite el value
    public Employee findemployeeId(@PathVariable int id)// Este metodo pasa parametro primitivo y lo busca en la a la coleecion q se llena con los @PostMapping
    {
    /*    Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                break;
            }else{empx=null;}
        }
        return empx; //serviciosEmployee.buscarEmployee(id);*/
        return servicesEmployee.findemployeeId(id);
    }

    @PatchMapping("/user/{id}")//update con un parametro
    public Employee upemployeeId(@PathVariable int id)
    {
      /*  Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                empx.setName("ramon valdez");
                break;
            }else{empx=null;}
        }
        return empx; //serviciosEmployee.buscarEmployee(id);*/
        return  servicesEmployee.upemployeeId(id);
    }
    @PatchMapping("/user/{id}/{name}")//update con 2(multiples parametros)
    public Employee upemployeeIdName(@PathVariable int id, @PathVariable String name)
    {
      /*  Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                empx.setName(name);
                break;
            }else{empx=null;}
        }
        return empx; //serviciosEmployee.buscarEmployee(id);*/
        return  servicesEmployee.upemployeeIdName(id,name);
    }

    @DeleteMapping("/user/{id}")//delete con un parametro
    public ArrayList delemployeeId(@PathVariable int id)
    {
   /*     Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                employees.remove(empx);
                break;
            }
        }
        return employees;*/
        return servicesEmployee.delemployeeId(id);
    }
}