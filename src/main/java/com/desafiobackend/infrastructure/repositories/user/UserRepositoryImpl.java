package com.desafiobackend.infrastructure.repositories.user;

import com.desafiobackend.application.exceptions.ResourceNotFoundException;
import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.domain.repositories.UserRepository;
import com.desafiobackend.infrastructure.entities.UserEntity;
import com.desafiobackend.infrastructure.mapper.user.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public User createUser(User user) {
        try{
            UserEntity userEntity = UserEntity.mapUserToUserEntity(user);
            UserEntity userEntityCreated = this.infraUserRepository.save(userEntity);
            return userMapper.toUser(userEntityCreated);
        }catch (Exception exception){
            throw new RuntimeException("Erro ao criar usuário: " , exception);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
       List<UserEntity> userEntities = this.infraUserRepository.findAll();
       return userMapper.toUsers(userEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) throws EntityNotFoundException {
        UserEntity userEntity =  this.infraUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado para o ID : " + id));
        return userMapper.toUser(userEntity);
    }
}
