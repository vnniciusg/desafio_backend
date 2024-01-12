package com.desafiobackend.dto.request.user;

import com.desafiobackend.domain.entities.user.UserType;

public record CreateUserRequestDTO(String firstName, String lastName , String document , String email , String password , UserType userType) {
}
