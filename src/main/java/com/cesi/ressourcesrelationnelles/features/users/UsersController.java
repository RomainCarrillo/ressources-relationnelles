package com.cesi.ressourcesrelationnelles.features.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cesi.ressourcesrelationnelles.domain.User;

@Controller
@RestController
public class UsersController {
 
	@Autowired
	private UserRepository userRepository;

 

    @GetMapping("/users")
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.insert(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }

//    @PutMapping("/users/{id}")
//    public User updateUser(@PathVariable long id, @RequestBody User user) {
//        user.setId(id);
//        return userRepository.(user);
//    }
}




