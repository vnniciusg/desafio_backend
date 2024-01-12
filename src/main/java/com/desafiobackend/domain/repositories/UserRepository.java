package com.desafiobackend.domain.repositories;

import com.desafiobackend.dto.request.user.CreateUserRequestDTO;
import com.desafiobackend.dto.response.user.CreateUserResponseDTO;

public interface UserRepository {
    CreateUserResponseDTO createUser(CreateUserRequestDTO requestDTO);
}
