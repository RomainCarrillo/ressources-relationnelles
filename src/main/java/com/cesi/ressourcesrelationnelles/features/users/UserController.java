package com.cesi.ressourcesrelationnelles.features.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String index() {
        return "Welcome user !";
    }
}
