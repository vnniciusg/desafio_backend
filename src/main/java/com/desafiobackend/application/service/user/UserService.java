package com.desafiobackend.application.service.user;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.dto.request.user.CreateUserRequestDTO;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> listUsers();
    User findById(Long id) throws EntityNotFoundException;

}
