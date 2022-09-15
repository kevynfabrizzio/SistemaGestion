package udea.edu.co.sistemagestion.gestion.Controladores;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Transaction;


@Controller
@RequestMapping("/enterprises")
public class TransactionController {
    //Enterprise e; Employee emp;Profile prof; ArrayList trans;ArrayList employees;

    // 1. El sistema devuelve reponses 200 en la ruta /enterprises/[id]/movements con GET
    @GetMapping("/movements/{id}")
    public Transaction findTansaction(@PathVariable int id)// Este metodo pasa parametro primitivo y lo busca en la a la coleecion q se llena con los @PostMapping
    {

        return new Transaction();
    }

    // 2. El sistema devuelve reponses 200 en la ruta /enterprises/[id]/movements con POST
    @PostMapping("/movements/{id}")//update con un parametro;
    public Transaction saveTran(@PathVariable long id)
    {
        return new Transaction();
    }

    // 3. El sistema devuelve reponses 200 en la ruta /enterprises/[id]/movements con PATCH
    @PatchMapping("/movements/{id}")//update con un parametro;
    public Transaction upTransaction(@PathVariable long id)
    {
        return new Transaction();
    }

    // 4. El sistema devuelve reponses 200 en la ruta /enterprises/[id] con GET
    @DeleteMapping("/movements/{id}")//delete con un parametro;
    public String deltransaction(@PathVariable int id)
    {
        return "Delete Ok";
    }
/*@RequestMapping("/enterprises/{id}/movements")
public class TransactionController {

        
    @GetMapping
    public ResponseEntity<Transaction> findById(@RequestBody Transaction movimiento) {
        return new ResponseEntity<Transaction>(movimiento, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Transaction> create(@RequestBody Transaction movimiento) {
        return new ResponseEntity<Transaction>(movimiento, HttpStatus.OK);

    }

    @PatchMapping
    public ResponseEntity<Transaction> update(@RequestBody Transaction movimiento) {
        return new ResponseEntity<Transaction>(movimiento, HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity<Transaction> delete(@RequestBody Transaction movimiento) {
        return new ResponseEntity<Transaction>(movimiento, HttpStatus.OK);
    }
 */
}