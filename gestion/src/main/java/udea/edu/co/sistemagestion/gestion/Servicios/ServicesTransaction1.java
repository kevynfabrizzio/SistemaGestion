package udea.edu.co.sistemagestion.gestion.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryEnterprise;
import udea.edu.co.sistemagestion.gestion.Entidades.Transaction;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryTransaction;

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

    //PATCH
    public Transaction updateTransaction(long id, Transaction transaction) {
        Transaction auxTransaction = new Transaction();// repositoryEnterprise.findById(id).orElse(null);
        auxTransaction.setId(transaction.getId());
        auxTransaction.setConcept(transaction.getConcept());
        auxTransaction.setAmount(transaction.getAmount());
        auxTransaction.setUser(transaction.getUser());
        auxTransaction.setEnterprise(transaction.getEnterprise());
        auxTransaction.setCreatedAt(transaction.getCreatedAt());
        auxTransaction.setUpdateAt(transaction.getUpdateAt());
        repositoryTransaction.save(auxTransaction);
        return new Transaction();
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
