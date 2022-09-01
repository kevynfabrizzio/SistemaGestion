package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

    @GetMapping(value = "/listar")
    public String listEnterprise() {
        return "Esto es una prueba";

    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<Employee> guardar(@RequestBody Employee empleado) {
        return new ResponseEntity<Employee>(empleado, HttpStatus.OK);

    }
}