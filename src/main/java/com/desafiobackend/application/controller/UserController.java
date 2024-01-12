package com.desafiobackend.application.controller;

import com.desafiobackend.application.service.user.UserService;
import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.dto.request.user.CreateUserRequestDTO;
import com.desafiobackend.dto.response.user.CreateUserResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDTO> createUser(@RequestBody CreateUserRequestDTO requestDTO ){
        User user = User.mapToUser(requestDTO);
        User responseDTO = this.userService.createUser(user);
        return new ResponseEntity<>(new CreateUserResponseDTO(responseDTO) , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
        List<User> users = this.userService.listUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>ListUser(@PathVariable Long id) throws EntityNotFoundException {
        User user = this.userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

}
