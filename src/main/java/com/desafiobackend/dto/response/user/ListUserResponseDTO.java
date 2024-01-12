package com.desafiobackend.dto.request.user;

import com.desafiobackend.domain.entities.user.UserType;

import java.math.BigDecimal;

public record ListUser(Long id , String firstName , String LastName , String document , String email , BigDecimal balance , UserType userType) {
}
