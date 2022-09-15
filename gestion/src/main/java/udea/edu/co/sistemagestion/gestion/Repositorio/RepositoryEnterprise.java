package udea.edu.co.sistemagestion.gestion.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;

@Repository
public interface RepositoryEnterprise extends JpaRepository<Enterprise, Long> {

}


