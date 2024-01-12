package com.desafiobackend.domain.repositories;

import com.desafiobackend.domain.entities.user.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface UserRepository {
    User createUser(User user);
    List<User> listUsers();
    User findById(Long id) throws EntityNotFoundException;
}
