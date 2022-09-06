package udea.edu.co.sistemagestion.gestion.Repositorio;

import org.springframework.stereotype.Repository;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import org.springframework.data.repository.CrudRepository;



public interface IRepositorioEnterprise extends CrudRepository<Enterprise, Long>{

}
