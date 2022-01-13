package com.cesi.ressourcesrelationnelles.features.users;

import com.cesi.ressourcesrelationnelles.domain.User;
import com.cesi.ressourcesrelationnelles.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUserList() {
        return userService.getlist();
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
