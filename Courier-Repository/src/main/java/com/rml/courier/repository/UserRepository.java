package com.rml.courier.repository;

import com.rml.courier.repository.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User save(User user);

    Boolean existsByUsername(String userName);

    Boolean existsByEmail(String email);

    boolean existsUserByUsername(String userName);

    boolean existsUserByEmail(String email);
}
