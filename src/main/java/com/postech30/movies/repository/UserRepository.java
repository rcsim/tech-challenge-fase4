package com.postech30.movies.repository;

import com.postech30.movies.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    User getUserById(String userId);
}
