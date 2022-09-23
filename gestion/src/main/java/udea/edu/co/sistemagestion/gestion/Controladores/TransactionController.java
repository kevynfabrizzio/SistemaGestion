package udea.edu.co.sistemagestion.gestion.Controladores;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Entidades.Transaction;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesTransaction1;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/enterprises/")
public class TransactionController {
    //Enterprise e; Employee emp;Profile prof; ArrayList trans;ArrayList employees;
    ServicesTransaction1 servicesTransaction;

    public TransactionController(ServicesTransaction1 servicesTransaction) {
        this.servicesTransaction = servicesTransaction;
    }

    /*ServicesEnterprise servicesEnterprise;

    public TransactionController(ServicesEnterprise servicesEnterprise) {
        this.servicesEnterprise = servicesEnterprise;
    }*/





    // 1. El sistema devuelve reponses 200 en la ruta /enterprises/[id]/movements con GET
    @GetMapping("movements")
    public String movements(Model model) {
        List<Transaction> listaMovimientos = servicesTransaction.transaction();
        model.addAttribute("transaction", listaMovimientos);
        return "/ingresosEgresos/ingresosEgresos";//Ruta de destino en la vista
    }
    @GetMapping(value = "movements/create")
    public String createTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "/ingresosEgresos/crearingresosEgresos";
    }

    @PostMapping(value = "movements/save")
    public String saveT(@ModelAttribute Transaction transaction) {
        servicesTransaction.saveTransaction(transaction);
        return "redirect:/ingresosEgresos/ingresosEgresos";
    }


    @GetMapping(value = "movements/update/{id}")
    public String updateFormT(@PathVariable("id") Long id, Model model) {
        Optional<Transaction> transaction = this.servicesTransaction.getById(id);
        model.addAttribute("transaction", transaction.get());
        return "ingresosEgresos/actualizarIngresosEgresos";
    }

    // Actualizar Datos Empresa
    @PostMapping(value = "movements/upgrade/{id}")
    public String updateTransaction(@ModelAttribute Transaction transaction) {
        servicesTransaction.saveTransaction(transaction);
        return "redirect:/enterprises/movements";
    }

    // 4. El sistema devuelve reponses 200 en la ruta /enterprises/[id] con GET
    /*@DeleteMapping("{id}/movements/")//delete con un parametro;
    public String deltransaction(@PathVariable Long id)
    {
        return "Delete Ok";
    }     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   */

    @PostMapping(value = "movements/deleteT")
    public String deleteTrans(@ModelAttribute Transaction transaction) {
        servicesTransaction.delete(transaction.getId());
        return "redirect:/ingresosEgresos/ingresosEgresos";
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