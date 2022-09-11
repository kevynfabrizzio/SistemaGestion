package udea.edu.co.sistemagestion.gestion.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryEnterprise;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;


@Service
public class ServicesEnterprise {

    List<Enterprise> enterprises;
    @Autowired
    RepositoryEnterprise repositoryEnterprise;

    public ServicesEnterprise(RepositoryEnterprise repositoryEnterprise){
        this.repositoryEnterprise = repositoryEnterprise;
    }

    //GET
    public List<Enterprise> enterprises(){
        return new ArrayList<Enterprise>(); //repositoryEnterprise.findAll();
    }

    //GETBYID
    public Enterprise findEnterprise(long id){
        return new Enterprise();// repositoryEnterprise.findById(id);
    }


    public Enterprise saveEnterprise(){
        Enterprise enterprise=new Enterprise();enterprise.setId(1);enterprise.setName("BroDevs");
        return enterprise;//
    }
    //POST
    public Enterprise saveEnterprise(Enterprise enterprise){
        return repositoryEnterprise.save(enterprise);
    }

    //PATCH
    public Enterprise updateEnterprise(long id, Enterprise enterprise){
    /*    Enterprise auxEnterprise = new Enterprise();// repositoryEnterprise.findById(id).orElse(null);
       auxEnterprise.setId(enterprise.getId());
        auxEnterprise.setName(enterprise.getName());
        auxEnterprise.setDocument(enterprise.getDocument());
        auxEnterprise.setPhone(enterprise.getPhone());
        auxEnterprise.setAddress(enterprise.getAddress());
      //  auxEnterprise.setUser(enterprise.getUser());
      //  auxEnterprise.setTransactions(enterprise.getTransactions());
        auxEnterprise.setCreatedAt(enterprise.getCreatedAt());
        auxEnterprise.setUpdatedAt(enterprise.getUpdatedAt());
      //  repositoryEnterprise.save(auxEnterprise);*/
        return new Enterprise();
    }

    //DELETE
    public String deleteEnterprise(int id){
        return "Delete OK";//repositoryEnterprise.delete(enterprise);
    }
    }

