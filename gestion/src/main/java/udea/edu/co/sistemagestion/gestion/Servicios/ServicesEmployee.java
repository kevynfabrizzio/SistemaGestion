package udea.edu.co.sistemagestion.gestion.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;
import udea.edu.co.sistemagestion.gestion.Entidades.Profile;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryEmployee;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicesEmployee {
    ArrayList employees;
    Profile prof;
    RepositoryEmployee repositoryEmployee;
    public ServicesEmployee(RepositoryEmployee repositoryEmployee){
        this.repositoryEmployee=repositoryEmployee;
    }
    public List<Employee> employees(){//El sistema permite consultar todos los usuarios
        return employees;// repositoryEmployee.findAll(); //  profileRepository.findAll();
    }
    public ArrayList savex() {//El sistema permite crear un usuario por postman
        //Entonces se crea un profile y se setea el ID(linea 25) para ejemplo(faltan los otros set); se podria haber utilizado el constuctor con parametros
        prof=new Profile();prof.setId("3");
        //se crea employee(linea 26); se setea con id automatico; se añade el profile anterior;
        Employee emp=new Employee();emp.setId(employees.size());emp.setName("ramiro");emp.setProfile(prof);
        if(employees==null || employees.size()==0){employees=new ArrayList();}//se asegura q solo exista una instancia de la coleccion
        employees.add(emp);//se guarda
        return employees;// retorna arraylist
    }
    public ArrayList savex1(Employee employee){//El sistema permite crear un usuario por postman
        //return new ResponseEntity<Employee>(empleado, HttpStatus.OK); // el profe retornaba con ResponseEntity
        if(employees==null || employees.size()==0){employees=new ArrayList();}//instancio coleccion si es null, para poder llenarla
        employees.add(employee);return employees;//guardo y retorno..
    }
    public Employee findemployeeId(int id){//El sistema permite consultar un solo usuario
        Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                break;
            }else{empx=null;}
        }
        return empx; //serviciosEmployee.buscarEmployee(id);
    }
    public Employee findemployeeIdx(int id)// Este metodo pasa parametro primitivo y lo busca en la a la coleecion q se llena con los @PostMapping
    {
        Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                break;
            }else{empx=null;}
        }
        return empx;
    }
    public Employee upemployeeId(int id){//El sistema permite editar un usuario con un param
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
    public Employee upemployeeIdName(int id, String name){//El sistema permite editar un usuario con 2 parametros
        Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                empx.setName(name);
                break;
            }else{empx=null;}
        }
        return empx; //serviciosEmployee.buscarEmployee(id);
    }
    public ArrayList upemployee(Employee employee){//El sistema permite editar un usuario con 2 parametros
        //return repositoryEmployee.save(employee);// employee;
        Employee empx=null;int i=0;
        for (Object emp:employees) {
            empx=(Employee)emp;
            if(empx.getId()==employee.getId()){
                employees.remove(empx);
                employees.add(i,employee); break;}
            i++;
        }
        return employees;// employee;
    }
    public ArrayList delemployeeId(@PathVariable int id){//El sistema permite eliminar un usuario
        Employee empx=null;
        for (Object emp : employees) {
            empx=(Employee)emp;
            if(empx.getId()==id){
                employees.remove(empx);
                break;
            }
        }
        return employees;
    }
   /* public Optional<Employee> EmployeesId(Long id){
        return repositoryEmployee.findById(id);
    }
    public Employee save(Employee employee){
        return repositoryEmployee.save(employee);
    }*/
}
