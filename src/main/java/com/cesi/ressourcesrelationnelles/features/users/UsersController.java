package com.cesi.ressourcesrelationnelles.features.users;

import com.cesi.ressourcesrelationnelles.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {

    @GetMapping("/users")
    public List<User> index() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(0,"alexandre.maindron@viacesi.fr", "123456789", "Alexandre", "MAINDRON"));
        userList.add(new User(1,"albert@gmail.com", "123", "Albert", "CAMUS"));
        userList.add(new User(2,"jacquie@gouv.fr", "15", "Jacques", "CHIRAC"));
        return userList;
    }
}
