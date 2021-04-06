package com.mongo.crud.security.repository;

import com.mongo.crud.security.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserName(String nombreUsuario);
    boolean existsByUserName(String nombreUsuario);
    boolean existsByEmail(String email);

}
