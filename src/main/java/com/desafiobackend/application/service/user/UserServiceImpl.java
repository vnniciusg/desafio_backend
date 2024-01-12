package com.desafiobackend.application.service.user;


import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.domain.repositories.UserRepository;
import com.desafiobackend.dto.request.user.CreateUserRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return null;
    }
}
