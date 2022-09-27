package udea.edu.co.sistemagestion.gestion.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryEnterprise;
import udea.edu.co.sistemagestion.gestion.Entidades.Transaction;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryTransaction;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesTransaction1 {
    @Autowired
    RepositoryTransaction repositoryTransaction;

    public ServicesTransaction1(RepositoryTransaction repositoryTransaction) {
        this.repositoryTransaction = repositoryTransaction;
    }

    //GET
    public List<Transaction> transaction(){
        return repositoryTransaction.findAll();
    }

    public Optional<Transaction> findById(long id){
        return repositoryTransaction.findById(id);
    }

    //GETBYID
    public Optional<Transaction> getById(long id) {
        return repositoryTransaction.findById(id);
    }

    //POST
    public Transaction saveTransaction(Transaction transaction) {
        return repositoryTransaction.save(transaction);
    }

    public Transaction savex (String concept, Float amount){
        Transaction trans = new Transaction();
        trans.getId();
        trans.getConcept();
        trans.getAmount();
        Employee emp = new Employee();
        emp.setId(1);
        trans.setUser(emp);
        Enterprise ent = new Enterprise();
        ent.setId(1);
        trans.setEnterprise(ent);
        trans.getCreatedAt();
        trans.getUpdateAt();
        repositoryTransaction.save(trans);
        return trans;
    }

    //DELETE
    public void delete(Long id) {
        repositoryTransaction.deleteById(id);
        System.out.println("OK");
    }

    public Optional <Transaction> buscar (Long id){
        return repositoryTransaction.findById(id);
    }
}
