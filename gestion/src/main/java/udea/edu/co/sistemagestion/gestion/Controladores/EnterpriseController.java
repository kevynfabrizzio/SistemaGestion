package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.ImplServicioEnterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.IServicioEnterprise;


import java.util.List;


@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

    @GetMapping()
    public List<Employee> getAll() {

        return "Esto es una prueba";
    }

    @PostMapping()
    public ResponseEntity<Employee> create(@RequestBody Employee empleado) {
        return new ResponseEntity<Employee>(empleado, HttpStatus.OK);

    }

    @GetMapping(value = "/enterprise/{id}")
    public Enterprise  getById(long id) {
        return ImplServicioEnterprise.getById(long id);
    }

    @PatchMapping(value = "/enterprise/{id}")
    public Enterprise update(long id, Enterprise enterprise){
        return ImplServicioEnterprise.update(long id, Enterprise enterprise)
    }

    @DeleteMapping(value = "/enterprise/{id}")
    public Enterprise delete(long id){
        ImplServicioEnterprise.delete(long id)
    }

}