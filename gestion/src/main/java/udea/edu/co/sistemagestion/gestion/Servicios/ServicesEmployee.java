package udea.edu.co.sistemagestion.gestion.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import udea.edu.co.sistemagestion.gestion.Entidades.Employee;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Entidades.Enum_RoleName;
import udea.edu.co.sistemagestion.gestion.Entidades.Profile;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryEmployee;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryProfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesEmployee {
    ArrayList employees;
    Profile profile;Enterprise enterp;
    @Autowired
    RepositoryEmployee repositoryEmployee;
    @Autowired
    RepositoryProfile repositoryProfile;

    @Autowired
    ServicesEnterprise servicesEnterprise;
    //  public ServicesEmployee(RepositoryEmployee repositoryEmployee,RepositoryProfile repositoryProfile){
    //     this.repositoryEmployee=repositoryEmployee;this.repositoryProfile=repositoryProfile;
    // }

    public List<Employee> employees(){//El sistema permite consultar todos los usuarios
        //return employees;// repositoryEmployee.findAll(); //  profileRepository.findAll();
        return repositoryEmployee.findAll(); //  profileRepository.findAll();
    }

    public String savex2(Employee employee, Model model, MultipartFile file) throws IOException {//El sistema permite crear un usuario por postman
        StringBuilder fileNames = new StringBuilder();

        String fileName = file.getOriginalFilename();
        //String direccion = application.getRealPath("/images/");
        //Path fileNameAndPath = Paths.get("./uploads/", file.getOriginalFilename());
        Path fileNameAndPath = Paths.get("C:/Users/HP/Documents/GitHub/myManualFork2/gestion/src/main/resources/static/img/uploads", file.getOriginalFilename());
        //fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        //model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        //return new ResponseEntity<Employee>(empleado, HttpStatus.OK); // el profe retornaba con ResponseEntity
        Profile profile = employee.getProfile();// new Profile();
        //profile.setId(1);
        // profile.setPhone(phone);
        profile.setImage(fileName);//fileNameAndPath.toString());
        profile.setCreatedAt(new Date());
        profile.setUpdatedAt(new Date());
        // guardo Objeto Profile
        repositoryProfile.save(profile);

        // crear el Objeto Employee
        // Employee employee = new Employee();
        //Asocio Profile recien creado con autonumerico ya asignado
        employee.setProfile(profile);
        // employee.setName(name);
        // employee.setEmail(email);
        //java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyyy/MM/dd");
        //String FR = formato.format(new Date());
        employee.setCreatedAt(new Date());
        employee.setUpdatedAt(new Date());

        Enterprise enterprise =servicesEnterprise.enterprises().get(0);// new Enterprise();
        //enterprise.setId(1);
        employee.setEnterprise(enterprise);
        if (employee.getRole().equals("Administrador")) {
            employee.setRole(Enum_RoleName.Admin);
        } else if (employee.getRole().equals("Operativo")) {
            employee.setRole(Enum_RoleName.Operario);
        }

        // guardar objeto Employee
        //repositoryEmployee.save(employee);
        repositoryEmployee.save(employee);
        return fileNameAndPath.toString();//employee;
    }

    public String savex23(Employee employee, Model model) throws IOException {//El sistema permite crear un usuario por postman
        StringBuilder fileNames = new StringBuilder();
        Profile profile = employee.getProfile();// new Profile();
        profile.setUpdatedAt(new Date());
        // guardo Objeto Profile
        repositoryProfile.save(profile);

        // crear el Objeto Employee
        // Employee employee = new Employee();
        //Asocio Profile recien creado con autonumerico ya asignado
        employee.setProfile(profile);
        // employee.setName(name);
        // employee.setEmail(email);
        //java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyyy/MM/dd");
        //String FR = formato.format(new Date());
        employee.setCreatedAt(new Date());
        employee.setUpdatedAt(new Date());

        Enterprise enterprise =servicesEnterprise.enterprises().get(0);// new Enterprise();
        //enterprise.setId(1);
        employee.setEnterprise(enterprise);
        if (employee.getRole().equals("Admin")) {
            employee.setRole(Enum_RoleName.Admin);
        } else if (employee.getRole().equals("Operario")) {
            employee.setRole(Enum_RoleName.Operario);
        }
        // guardar objeto Employee
        //repositoryEmployee.save(employee);
        repositoryEmployee.save(employee);
        return "";//employee;
    }

    public Profile savex3(Profile profile){//El sistema permite crear un usuario por postman
        //return new ResponseEntity<Employee>(empleado, HttpStatus.OK); // el profe retornaba con ResponseEntity
        repositoryProfile.save(profile);
        return profile;
    }

    public void delemployeeObj(Employee employee){//El sistema permite eliminar un usuario
        repositoryEmployee.delete(employee);
        repositoryProfile.delete(employee.getProfile());
    }

    public Optional<Employee> findemployeeId(long id){//El sistema permite consultar un solo usuario
      return repositoryEmployee.findById(Long.valueOf(id));
    }
}
