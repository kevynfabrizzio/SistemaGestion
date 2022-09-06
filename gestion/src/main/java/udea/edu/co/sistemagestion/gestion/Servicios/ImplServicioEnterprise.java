package udea.edu.co.sistemagestion.gestion.Servicios;

import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Repositorio.IRepositorioEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplServicioEnterprise implements IServicioEnterprise{


    @Autowired
    IServicioEnterprise repositoryEnterprise;

    @Override
    public List<Enterprise> getAll() {
        return null;
    }

    @Override
    public Enterprise create(Enterprise enterprise) {
        return null;
    }

    @Override
    public Enterprise getById(long id) {
        return null;
    }

    @Override
    public Enterprise update(long id, Enterprise enterprise) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
