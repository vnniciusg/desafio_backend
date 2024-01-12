package com.desafiobackend.infrastructure.repositories;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.domain.repositories.UserRepository;
import com.desafiobackend.dto.request.user.CreateUserRequestDTO;
import com.desafiobackend.dto.response.user.CreateUserResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {


    @Override
    public CreateUserResponseDTO createUser(CreateUserRequestDTO requestDTO) {
        return null;
    }
}
