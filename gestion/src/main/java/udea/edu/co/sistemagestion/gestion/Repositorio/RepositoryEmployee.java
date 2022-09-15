package udea.edu.co.sistemagestion.gestion.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;

@Repository
public interface RepositoryEmployee extends JpaRepository<Employee, Long> {

}
