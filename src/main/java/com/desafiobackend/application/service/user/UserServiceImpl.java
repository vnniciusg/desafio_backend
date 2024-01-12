package com.desafiobackend.application.service.user;


import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.createUser(user);
    }

    @Override
    public List<User> listUsers() {
        return this.userRepository.listUsers();
    }

    @Override
    public User findById(Long id) throws EntityNotFoundException {
        return this.userRepository.findById(id);
    }
}
