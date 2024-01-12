package com.desafiobackend.infrastructure.repositories;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.domain.repositories.UserRepository;
import com.desafiobackend.infrastructure.entities.UserEntity;
import com.desafiobackend.infrastructure.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final InfraUserRepository infraUserRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserRepositoryImpl(InfraUserRepository infraUserRepository, UserMapper userMapper) {
        this.infraUserRepository = infraUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {

        UserEntity userEntity = UserEntity.mapUserToUserEntity(user);

        UserEntity userEntityCreated = this.infraUserRepository.save(userEntity);

        return userMapper.toUser(userEntityCreated);

    }
}
