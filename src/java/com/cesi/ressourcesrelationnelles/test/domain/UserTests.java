package java.com.cesi.ressourcesrelationnelles.test.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.cesi.ressourcesrelationnelles.domain.User;

class UserTests {

    @Test
    void createUser(){
        User user = new User();
        user.setFirstName("Alexandre");
        user.setLastName("MAINDRON");
        user.setEmail("alexandre.maindron@viacesi.fr");
        user.setPassword("123456789");
        assertNotNull(user);
        assertEquals("Alexandre", user.getFirstName());
        assertEquals("MAINDRON", user.getLastName());
        assertEquals("alexandre.maindron@viacesi.fr", user.getEmail());
        assertEquals("123456789", user.getPassword());
    }

    @Test
    void getUserFullname(){
        User user = new User();
        user.setFirstName("Alexandre");
        user.setLastName("MAINDRON");
        assertNotNull(user);
        assertEquals("Alexandre MAINDRON", user.getFullName());
    }
}
