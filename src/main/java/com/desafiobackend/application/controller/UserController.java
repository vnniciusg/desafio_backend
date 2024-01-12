package com.desafiobackend.application.controller;

import com.desafiobackend.application.service.user.UserService;
import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.dto.request.user.CreateUserRequestDTO;
import com.desafiobackend.dto.response.user.CreateUserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> CreateUser(@RequestBody CreateUserRequestDTO requestDTO ,  UriComponentsBuilder UriBuilder){
        User user = User.mapToUser(requestDTO);
        User responseDTO = this.userService.createUser(user);
        var uri = UriBuilder.path("/users/{id}").buildAndExpand(responseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(new CreateUserResponseDTO(responseDTO));
    }


}
