package udea.edu.co.sistemagestion.gestion.Servicios;

import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import java.util.List;

public interface IServicioEnterprise {

    //Definimos mensajes(metodos sin cuerpo)
    //Get --> Consulta todas la empresas
    public List<Enterprise> getAll();

    //Post --> Crea una empresa
    public Enterprise create(Enterprise enterprise);

    //Get --> Se consulta por un id
    public Enterprise getById(long id);

    //patch --> Se actualiza por id
    public Enterprise update(long id, Enterprise enterprise);

    //delete
    public void delete(long id);





}
