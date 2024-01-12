package com.desafiobackend.infrastructure.repositories;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.domain.repositories.UserRepository;
import com.desafiobackend.infrastructure.entities.UserEntity;
import com.desafiobackend.infrastructure.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<User> listUsers() {
       List<UserEntity> userEntities = this.infraUserRepository.findAll();
        return userMapper.toUsers(userEntities);
    }

    @Override
    public User findById(Long id) throws Exception{
        UserEntity userEntity =  this.infraUserRepository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
        return userMapper.toUser(userEntity);

    }
}
