package udea.edu.co.sistemagestion.gestion.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryEnterprise;

import java.util.Optional;
import java.util.List;

@Service
public class ServicesEnterprise {

    @Autowired
    RepositoryEnterprise repositoryEnterprise;

    public ServicesEnterprise(RepositoryEnterprise repositoryEnterprise) {
        this.repositoryEnterprise = repositoryEnterprise;
    }

    //GET
    public List<Enterprise> enterprises(){
        return repositoryEnterprise.findAll();
    }

    public Optional<Enterprise> findById(long id){
        return repositoryEnterprise.findById(id);
    }

    //GETBYID
    public Optional<Enterprise> getById(long id) {
        return repositoryEnterprise.findById(id);
    }

    //POST
    public Enterprise saveEnterprise(Enterprise enterprise) {
        return repositoryEnterprise.save(enterprise);
    }

    //PATCH
    public Enterprise updateEnterprise(long id, Enterprise enterprise) {
     Enterprise auxEnterprise = new Enterprise();// repositoryEnterprise.findById(id).orElse(null);
       auxEnterprise.setId(enterprise.getId());
        auxEnterprise.setName(enterprise.getName());
        auxEnterprise.setDocument(enterprise.getDocument());
        auxEnterprise.setPhone(enterprise.getPhone());
        auxEnterprise.setAddress(enterprise.getAddress());
        auxEnterprise.setUser(enterprise.getUser());
        auxEnterprise.setTransactions(enterprise.getTransactions());
        auxEnterprise.setCreatedAt(enterprise.getCreatedAt());
        auxEnterprise.setUpdatedAt(enterprise.getUpdatedAt());
        repositoryEnterprise.save(auxEnterprise);
        return new Enterprise();
    }

    //DELETE
    public void delete(Long id) {
        repositoryEnterprise.deleteById(id);
        System.out.println("OK");
    }

    public Optional <Enterprise> buscar (Long id){
        return repositoryEnterprise.findById(id);
    }

}