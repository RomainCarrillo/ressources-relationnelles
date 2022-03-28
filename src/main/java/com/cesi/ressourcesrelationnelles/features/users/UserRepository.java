package com.cesi.ressourcesrelationnelles.features.users;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cesi.ressourcesrelationnelles.domain.User;

public interface UserRepository extends MongoRepository<User, Long> {

    List<User> findByEmail(String email);
    List<User> findByPassword(String password);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);

//    // Supports native JSON query string
//    @Query("{firstName:'?0'}")
//    List<User> findCustomByFirstName(String firstName);

}
