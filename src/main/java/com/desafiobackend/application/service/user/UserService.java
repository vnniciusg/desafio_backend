package com.desafiobackend.application.service.user;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.dto.request.user.CreateUserRequestDTO;

public interface UserService {
    User createUser(User user);
}
