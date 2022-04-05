package com.cesi.ressourcesrelationnelles.features.users;

import com.cesi.ressourcesrelationnelles.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByEmail(String email);
    List<User> findUserByFirstName(String firstName);
    List<User> findUserByLastName(String lastName);

    @Query("{lastName:'?0'}")
    List<User> findUserByName(String lastName);
}
