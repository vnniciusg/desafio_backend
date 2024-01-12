package com.desafiobackend.dto.response.user;

import com.desafiobackend.domain.entities.user.UserType;

import java.math.BigDecimal;

public record ListUserResponseDTO(Long id , String firstName , String LastName , String document , String email , BigDecimal balance , UserType userType) {
}
