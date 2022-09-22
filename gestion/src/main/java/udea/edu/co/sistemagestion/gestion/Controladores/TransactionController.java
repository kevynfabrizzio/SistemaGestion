package udea.edu.co.sistemagestion.gestion.Controladores;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Entidades.Transaction;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesTransaction1;

import java.util.List;


@Controller
@RequestMapping("/enterprises/")
public class TransactionController {
    //Enterprise e; Employee emp;Profile prof; ArrayList trans;ArrayList employees;
    ServicesTransaction1 servicesTransaction;

    public TransactionController(ServicesTransaction1 servicesTransaction) {
        this.servicesTransaction = servicesTransaction;
    }





    // 1. El sistema devuelve reponses 200 en la ruta /enterprises/[id]/movements con GET
    @GetMapping("{id}/movements")
    public String movements(Model model) {
        List<Transaction> listaMovimientos = servicesTransaction.transaction();
        model.addAttribute("transaction", listaMovimientos);
        return "/ingresosEgresos/ingresosEgresos";//Ruta de destino en la vista
    }
    /*
    public Transaction findTransaction(@PathVariable int id)// Este metodo pasa parametro primitivo y lo busca en la a la coleecion q se llena con los @PostMapping
    {

        return new Transaction();
    }*/

    // 2. El sistema devuelve reponses 200 en la ruta /enterprises/[id]/movements con POST
    @PostMapping("/movements/{id}")//update con un parametro;
    public Transaction saveTran(@PathVariable long id)
    {
        return new Transaction();
    }

    // 3. El sistema devuelve reponses 200 en la ruta /enterprises/[id]/movements con PATCH
    /*@PatchMapping("/movements/{id}")//update con un parametro;
    public Transaction upTransaction(@PathVariable long id)
    {
        return new Transaction();
    } +++++++++++++++++ */

    @PatchMapping("{id}/movements/")//update con un parametro;
    public String upTransaction(@PathVariable("id") long id, Transaction transaction) {
        servicesTransaction.saveTransaction(transaction);
        return "ingresosEgresos/actualizarIngresosEgresos";
    }

    // 4. El sistema devuelve reponses 200 en la ruta /enterprises/[id] con GET
    /*@DeleteMapping("{id}/movements/")//delete con un parametro;
    public String deltransaction(@PathVariable Long id)
    {
        return "Delete Ok";
    }     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   */

    @DeleteMapping(value = "{id}/movements/delete")
    public String deleteTrans(@ModelAttribute Transaction transaction) {
        servicesTransaction.delete(transaction.getId());
        return "ingresosEgresos/ingresosEgresos";
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