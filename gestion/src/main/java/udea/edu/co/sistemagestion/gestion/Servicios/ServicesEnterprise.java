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
    public List<Enterprise> enterprises() {
        return repositoryEnterprise.findAll();
    }

    //GETBYID
    public Optional<Enterprise> getById(long id) {
        return repositoryEnterprise.findById(id);
    }

    //POST
    public Enterprise saveEnterprise(Enterprise enterprise) {
        return repositoryEnterprise.save(enterprise);
    }

    //DELETE
    public void delete(Enterprise enterprise) {

        repositoryEnterprise.delete(enterprise);
        System.out.println("OK");
    }

}