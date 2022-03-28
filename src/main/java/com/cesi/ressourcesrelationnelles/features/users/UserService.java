package com.cesi.ressourcesrelationnelles.features.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesi.ressourcesrelationnelles.domain.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getlist() {
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}