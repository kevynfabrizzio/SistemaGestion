package udea.edu.co.sistemagestion.gestion.Controladores;


import org.springframework.web.bind.annotation.*;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Servicios.ServicesEnterprise;
import java.util.Optional;
import java.util.List;


@RestController
@RequestMapping("/enterprises")
public class EnterpriseController{

    ServicesEnterprise servicesEnterprise;

    public EnterpriseController(ServicesEnterprise servicesEnterprise) {
        this.servicesEnterprise = servicesEnterprise;
    }

    // 1. El sistema devuelve reponses 200 en la ruta /enterprises con GET
    @GetMapping
    public List<Enterprise> enterprises()
    {
        //este metodo se accede con localhost:8080/users, y retorna la coleccion
        return servicesEnterprise.enterprises();
    }

    // 2. El sistema devuelve reponses 200 en la ruta /enterproses con POST
    @PostMapping
    public Enterprise savex() {
        return servicesEnterprise.saveEnterprise();//savex();// employees;// retorna arraylist
    }

    // 3. El sistema devuelve reponses 200 en la ruta /enterprises/[id] con GET
    @GetMapping("/{id}")
    public Enterprise findenterpriseId(@PathVariable int id)// Este metodo pasa parametro primitivo y lo busca en la a la coleecion q se llena con los @PostMapping
    {
        return servicesEnterprise.findEnterprise(id);
    }

    // 4. El sistema devuelve reponses 200 en la ruta /enterprises/[id] con PATCH
    @PatchMapping("/{id}")//update con un parametro;
    public Enterprise upenterpriseid(@PathVariable long id)
    {
        return servicesEnterprise.updateEnterprise(id,null);//pemployeeId(id);
    }

    // 5. El sistema devuelve reponses 200 en la ruta /enterprises/[id] con GET
    @DeleteMapping("/{id}")//delete con un parametro;
    public String delenterpriseId(@PathVariable int id)
    {
        return servicesEnterprise.deleteEnterprise(id);//elemployeeId(id);
    }
  /*  //
    @GetMapping()
    public List<Enterprise> enterprises() {
        return servicesEnterprise.enterprises();
    }

    //
    @PostMapping()
    public Enterprise create(@RequestBody Enterprise enterprise){
        return servicesEnterprise.saveEnterprise(enterprise);
    }

    @GetMapping(value = "/enterprise/{id}")
    public Optional<Enterprise> findBy (@PathVariable long id){
        return servicesEnterprise.findEnterprise(id);
    }

    @PatchMapping(value = "/enterprise/{id}")
    public Enterprise update(@RequestBody long id, @RequestBody Enterprise enterprise){
        return servicesEnterprise.updateEnterprise(id,enterprise);
    }

    @DeleteMapping(value = "/enterprise/{id}")
    public String delete(@PathVariable Enterprise enterprise){
        servicesEnterprise.deleteEnterprise(enterprise);
        return "redirect:/enterprise";
    }*/

}