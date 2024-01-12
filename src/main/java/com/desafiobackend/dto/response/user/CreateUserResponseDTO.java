package com.desafiobackend.dto.response.user;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.domain.entities.user.UserType;

import java.math.BigDecimal;

public record CreateUserResponseDTO(Long id , String firstName , String LastName , String document , String email , BigDecimal balance , UserType userType) {
    public CreateUserResponseDTO(User user){
        this(user.getId() , user.getFirstName() , user.getLastName(), user.getDocument() , user.getEmail() , user.getBalance() , user.getUserType());
    }
}
