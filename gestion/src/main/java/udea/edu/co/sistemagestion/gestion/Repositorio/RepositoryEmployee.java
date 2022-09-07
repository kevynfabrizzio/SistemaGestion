package udea.edu.co.sistemagestion.gestion.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;

public interface RepositoryEmployee extends JpaRepository<Employee,Long> {
}
