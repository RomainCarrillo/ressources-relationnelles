package com.cesi.ressourcesrelationnelles.services;

import com.cesi.ressourcesrelationnelles.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void createUserTest() {
        User user = new User();
        userService.createUser(user);
        List<User> userList = userService.getlist();
        assertNotNull(userList);
        assertEquals(1, userList.size());
    }
}
