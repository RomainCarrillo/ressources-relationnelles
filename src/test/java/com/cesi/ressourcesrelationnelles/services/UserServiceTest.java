package com.cesi.ressourcesrelationnelles.services;

import com.cesi.ressourcesrelationnelles.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUserTest() {
        User user = new User();
        userService.createUser(user);
        List<User> userList = userService.list();
        Assert.assertNotNull(userList);
        Assert.assertEquals(1, userList.size());
    }
}