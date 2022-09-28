package udea.edu.co.sistemagestion.gestion.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Entidades.Transaction;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEmployee;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesTransaction1;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/enterprises/{id}/movements")
public class TransactionController {

    ServicesTransaction1 servicesTransaction;
    ServicesEnterprise servicesEnterprise;

    public TransactionController(ServicesTransaction1 servicesTransaction) {
        this.servicesTransaction = servicesTransaction;
    }
    // Listar
    @GetMapping(value = "/list")
    public String movements(@ModelAttribute Enterprise enterprise, Model model) {
        List<Transaction> listaMovimientos = servicesTransaction.transaction();
        List<Transaction> lista1 = new ArrayList<>();
        for (int i = 0; i < listaMovimientos.size(); i++){
            if (listaMovimientos.get(i).getEnterprise().getId()== enterprise.getId()){
                lista1.add(listaMovimientos.get(i));
            }
        }
        model.addAttribute("transaction", lista1);
        return "/ingresosEgresos/ingresosEgresos";//Ruta de destino en la vista
    }
    // Crear
    @GetMapping
    public String createTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("enterprise", new  Enterprise());
        model.addAttribute("user", new Employee());
        return "/ingresosEgresos/nuevoEngreso";
    }

    // Guardar
    @PostMapping
    public String saveT(@ModelAttribute Transaction transaction) {
        servicesTransaction.saveTransaction(transaction);
        return "redirect:/enterprises/{id}/movements/list";
    }

    // Actualizar Datos Empresa
    @PatchMapping
    public String updateTransaction(@ModelAttribute Transaction transaction) {
        servicesTransaction.saveTransaction(transaction);
        return "redirect:/enterprises/{id}/movements/list";
    }

    // Eliminar
    @DeleteMapping
    public String deleteTrans(@ModelAttribute Transaction transaction) {
        servicesTransaction.delete(transaction.getId());
        return "redirect:/enterprises/{id}/movements/list";
    }

}