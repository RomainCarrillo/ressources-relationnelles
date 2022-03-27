package com.cesi.ressourcesrelationnelles.repository;

import com.cesi.ressourcesrelationnelles.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {



    List<User> findByEmail(String email);
    List<User> findByPassword(String password);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);

    // Supports native JSON query string
    @Query("{firstName:'?0'}")
    List<User> findCustomByFirstName(String firstName);

}
