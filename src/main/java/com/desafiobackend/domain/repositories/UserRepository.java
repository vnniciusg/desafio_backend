package com.desafiobackend.domain.repositories;

import com.desafiobackend.domain.entities.user.User;

public interface UserRepository {
    User createUser(User user);
}
