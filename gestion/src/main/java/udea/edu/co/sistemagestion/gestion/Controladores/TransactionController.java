package udea.edu.co.sistemagestion.gestion.Controladores;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Transaction;


@RestController
@RequestMapping("/enterprises/{id}/movements")
public class TransactionController {

        
    @GetMapping
    public ResponseEntity<Transaction> findById(@RequestBody Transaction movimiento) {
        return new ResponseEntity<Transaction>(movimiento, HttpStatus.OK);
    }
    /*
    ArrayList transactions;

    @GetMapping
    public Transaction  getById(long id) {
        Transaction trnsc=null;
        for (Object trn : transactions) {
            trnsc=(Transaction)trn;
            if(trnsc.getId()==id){
                break;
            }else{trnsc=null;}
        }
        return trnsc;
    }*/
    
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
    /*
    @DeleteMapping
    public Transaction delete(long id){
        Transaction trnsc=null;
        for (Object trn : transactions) {
            trnsc=(Transaction)trn;
            if(trnsc.getId()==id){
                transactions.remove(trnsc);
                break;
            }
        }
        return transactions;
    }*/

}