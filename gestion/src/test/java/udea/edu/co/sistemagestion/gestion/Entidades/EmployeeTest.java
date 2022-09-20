package udea.edu.co.sistemagestion.gestion.Entidades;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Profile;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getName() {
        Employee em =new Employee(12,"ramonw","fre@rre.er",null,Enum_RoleName.Admin,null,null, new Date(), new Date());
        assertEquals("ramonw",em.getName());
    }

    @Test
    void getRole() {
        Employee em =new Employee(12,"ramonw","fre@rre.er",null,Enum_RoleName.Admin,null,null, new Date(), new Date());
        assertEquals(Enum_RoleName.Operario,em.getRole());
    }

}